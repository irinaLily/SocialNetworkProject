package dao.model;

import java.time.LocalDate;

/**
 * Created by Ирина on 04.05.2016.
 */
public class FriendshipDto {
    private Long id;
    private PersonDto personId;
    private PersonDto friendId;
    private LocalDate dataFrom;

    public PersonDto getPersonId() {
        return personId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPersonId(PersonDto personId) {
        this.personId = personId;
    }

    public PersonDto getFriendId() {
        return friendId;
    }

    public void setFriendId(PersonDto friendId) {
        this.friendId = friendId;
    }

    public LocalDate getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendshipDto that = (FriendshipDto) o;

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
        return "FriendshipDto{" +
                "personId.id=" + personId.getId() +
                ", friendId.id=" + friendId.getId() +
                ", dataFrom=" + dataFrom +
                '}';
    }
}
