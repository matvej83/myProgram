package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "like")

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "likes_for_users",
            joinColumns = @JoinColumn(
                    name = "like_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )
    )
    private List<User> applicableToUser = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "likes_for_photo",
            joinColumns = @JoinColumn(
                    name = "like_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "photo_id",
                    referencedColumnName = "id"
            )
    )
    private List<Photo> applicableToPhoto = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "likes_for_comment",
            joinColumns = @JoinColumn(
                    name = "like_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "comment_id",
                    referencedColumnName = "id"
            )
    )
    private List<Comment> applicableToComment = new ArrayList<>();


    public Like(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getApplicableToUser() {
        return applicableToUser;
    }

    public void setApplicableToUser(List<User> applicableToUser) {
        this.applicableToUser = applicableToUser;
    }

    public List<Photo> getApplicableToPhoto() {
        return applicableToPhoto;
    }

    public void setApplicableToPhoto(List<Photo> applicableToPhoto) {
        this.applicableToPhoto = applicableToPhoto;
    }

    public List<Comment> getApplicableToComment() {
        return applicableToComment;
    }

    public void setApplicableToComment(List<Comment> applicableToComment) {
        this.applicableToComment = applicableToComment;
    }
}
