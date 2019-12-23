package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "photo")

public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "applicableToPhoto")
    private List<Like> likes = new ArrayList<>();

    @ManyToMany(mappedBy = "applicableToPhoto")
    private List<Comment> comments = new ArrayList<>();

    public Photo() {

    }

    public Photo(String title, String author) {
        this.title = title;
        this.author = user.getName();
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

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addLike(String author) {
        if (likes.size() == 0) {
            Like like = new Like(author);
            likes.add(like);
        } else return;
    }

    public void addComment(String author, String text) {
        Comment comment = new Comment();
        comment.setText(text);
        comments.add(comment);
    }

//    public void withdrawLike(User user, Object targetObject){
//        if(likes.get(0).getAuthor().equals(user)){
//            likes.clear();
//        } else return;
//    }

}