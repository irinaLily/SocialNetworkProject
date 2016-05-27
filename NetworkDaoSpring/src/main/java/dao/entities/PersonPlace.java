package dao.entities;

import javax.persistence.*;

/**
 * Created by Ирина on 23.05.2016.
 */
@Entity
@Table(name = "PERSON_PlACE")
public class PersonPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLACE_ID")
    private Place place;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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

        PersonPlace that = (PersonPlace) o;

        if (id != that.id) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        return !(person != null ? !person.equals(that.person) : that.person != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonPlace{" +
                "id=" + id +
                ", place=" + place.getId() +
                ", person=" + person.getId() +
                '}';
    }
}
