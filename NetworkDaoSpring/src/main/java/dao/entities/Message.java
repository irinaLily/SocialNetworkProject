package dao.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "MESSAGE")
public class Message implements HasID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "TIME_SENT")
    private LocalDate timeSent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_FROM")
    private Person personFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_TO")
    private Person personTo;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id=id;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDate timeSent) {
        this.timeSent = timeSent;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }

    public Person getPersonTo() {
        return personTo;
    }

    public void setPersonTo(Person personTo) {
        this.personTo = personTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return id == message.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeSent=" + timeSent +
                ", person_from.id=" + personFrom.getId() +

                '}';
    }
}
