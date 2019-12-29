package entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "photo")

public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "likedPhotos")
    Set<User> whoLikesPhotos = new HashSet<>();

    public Photo() {

    }

    public Photo(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<User> getWhoLikesPhotos() {
        return whoLikesPhotos;
    }

    public void setWhoLikesPhotos(Set<User> whoLikesPhotos) {
        this.whoLikesPhotos = whoLikesPhotos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id.equals(photo.id) &&
                title.equals(photo.title) &&
                user.equals(photo.user) &&
                Objects.equals(comments, photo.comments) &&
                Objects.equals(whoLikesPhotos, photo.whoLikesPhotos);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(whoLikesPhotos);
//    }
}