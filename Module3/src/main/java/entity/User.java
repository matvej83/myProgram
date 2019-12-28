package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    public void setLikedPhotos(HashSet<Photo> likedPhotos) {
        this.likedPhotos = likedPhotos;
    }

    public void likePhoto(Photo photo) {
        this.likedPhotos.add(photo);
        photo.whoLikes.add(this);
    }

}

//1. вместо сущности лайков создать связь liked many to many между user/comment/photo. это таблица связей join table.
//2. map superclass,  uniq constrains

//ограничение на число лайков - уникальный индекс или singletable