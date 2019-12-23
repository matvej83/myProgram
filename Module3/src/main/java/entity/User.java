package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Photo> photos;

    @ManyToMany(mappedBy = "applicableToUser")
    private List<Like> likes = new ArrayList<>();

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

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public void addPhotos(String title) {
        Photo photo = new Photo();
        photo.setUser(this);
        photo.setTitle(title);
        photos.add(photo);
    }

    public void addLike(String author) {
        if (likes.size() < 1) {
            Like like = new Like(author);
            likes.add(like);
        } else return;
    }

    public void withdrawLike(Object targetObject){
        likes.clear();
    }

}