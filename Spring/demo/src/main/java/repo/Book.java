package repo;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    public void setTitle(String s) {
        title = s;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String a){
        author = a;
    }

    public String getAuthor(){
        return author;
    }

    public void setId(long l) {
        id = l;
    }

    public long getId() {
        return id;
    }
}
