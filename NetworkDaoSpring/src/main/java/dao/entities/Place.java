package dao.entities;

import javax.persistence.*;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "PLACE")
public class Place implements HasID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LATITUDE")
    private int latitude;
    @Column(name = "LONGITUDE")
    private int longitude;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (id != place.id) return false;
        if (latitude != place.latitude) return false;
        if (longitude != place.longitude) return false;
        if (title != null ? !title.equals(place.title) : place.title != null) return false;
        return !(description != null ? !description.equals(place.description) : place.description != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + latitude;
        result = 31 * result + longitude;
        return result;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
