package entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "comment")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @ManyToMany(mappedBy = "likedComments")
    Set<User> whoLikesComments = new HashSet<>();

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Set<User> getWhoLikesComments() {
        return whoLikesComments;
    }

    public void setWhoLikesComments(Set<User> whoLikesComments) {
        this.whoLikesComments = whoLikesComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id) &&
                text.equals(comment.text) &&
                user.equals(comment.user) &&
                Objects.equals(photo, comment.photo) &&
                Objects.equals(whoLikesComments, comment.whoLikesComments);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(whoLikesComments);
//    }
}
