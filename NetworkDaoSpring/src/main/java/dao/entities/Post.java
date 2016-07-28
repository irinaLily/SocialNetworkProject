package dao.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "POST")
public class Post implements HasID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private  String content;
    @Column(name = "PLASE_TAME")
    private LocalDate plase_time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;
/*   @ManyToMany
   @JoinTable(
           name = "POST_LIKES",
           inverseJoinColumns = @JoinColumn(name ="PERSON_ID" ),
           joinColumns = @JoinColumn(name = "POST_ID")
   )
    private Set<Person> persons;*/



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPlase_time() {
        return plase_time;
    }

    public void setPlase_time(LocalDate plase_time) {
        this.plase_time = plase_time;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id == post.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", plase_time='" + plase_time + '\'' +

                '}';
    }
}
