package dao.entities;

import javax.persistence.*;

/**
 * Created by Ирина on 24.05.2016.
 */
@Entity
@Table(name = "PERSON_HOBBY")
public class PersonHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOBBY_ID")
    private Hobby hobby;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonHobby that = (PersonHobby) o;

        if (id != that.id) return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;
        return !(person != null ? !person.equals(that.person) : that.person != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonHobby{" +
                "id=" + id +
                ", hobby=" + hobby.getId() +
                ", person=" + person.getId() +
                '}';
    }
}
