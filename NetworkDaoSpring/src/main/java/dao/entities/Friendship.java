package dao.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "FRIENDSHIP")
public class Friendship  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person personId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRIEND_ID")
    private Person friendId;
    @Column(name = "DATA_FROM")
    private LocalDate dataFrom;

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Person getFriendId() {
        return friendId;
    }

    public void setFriendId(Person friendId) {
        this.friendId = friendId;
    }

    public LocalDate getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friendship that = (Friendship) o;

        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (friendId != null ? !friendId.equals(that.friendId) : that.friendId != null) return false;
        return !(dataFrom != null ? !dataFrom.equals(that.dataFrom) : that.dataFrom != null);

    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (friendId != null ? friendId.hashCode() : 0);
        result = 31 * result + (dataFrom != null ? dataFrom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "personId=" + personId +
                ", friendId=" + friendId +
                ", dataFrom=" + dataFrom +
                '}';
    }
}
