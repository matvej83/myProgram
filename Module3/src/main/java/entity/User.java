package entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "liked_photos",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    Set<Photo> likedPhotos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "liked_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "target_user_id"))
    Set<User> likedUsers = new HashSet<>();

    @ManyToMany(mappedBy = "likedUsers")
    Set<User> whoLikesUsers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "liked_comments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    Set<Comment> likedComments = new HashSet<>();

    public User() {

    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addPhotos(String title) {
        Photo photo = new Photo();
        photo.setUser(this);
        photo.setTitle(title);
        photos.add(photo);
        this.setPhotos(photos);
    }

    public void addComment(Photo photo, String text) {
        Comment comment = new Comment();
        comment.setUser(this);
        comment.setText(text);
        comment.setPhoto(photo);
        comments.add(comment);
    }

    public Set<Photo> getLikedPhotos() {
        return likedPhotos;
    }

    public void setLikedPhotos(Set<Photo> likedPhotos) {
        this.likedPhotos = likedPhotos;
    }

    public Set<User> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(Set<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public void likePhoto(Photo photo) {
        this.likedPhotos.add(photo);
        photo.whoLikesPhotos.add(this);
    }

    public void likeUser(User user) {
        this.likedUsers.add(user);
        user.whoLikesUsers.add(this);
    }

    public void likeComment(Comment comment) {
        this.likedComments.add(comment);
        comment.whoLikesComments.add(this);
    }

    public void withdrawLikesUser(User user, Set likedUsers) {
        this.likedPhotos.remove(user);
        user.whoLikesUsers.remove(user);
    }

    public void withdrawLikesPhoto(Photo photo, Set likedPhotos) {
        this.likedPhotos.remove(photo);
        photo.whoLikesPhotos.remove(photo);
    }

    public void withdrawLikesComments(Comment comment, Set likedComments) {
        this.likedPhotos.remove(comment);
        comment.whoLikesComments.remove(comment);
    }

    public Set<User> getWhoLikesUsers() {
        return whoLikesUsers;
    }

    public void setWhoLikesUsers(Set<User> whoLikesUsers) {
        this.whoLikesUsers = whoLikesUsers;
    }

    public Set<Comment> getLikedComments() {
        return likedComments;
    }

    public void setLikedComments(Set<Comment> likedComments) {
        this.likedComments = likedComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}