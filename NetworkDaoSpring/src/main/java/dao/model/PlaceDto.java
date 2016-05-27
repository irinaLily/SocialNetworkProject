package dao.model;

/**
 * Created by Ирина on 04.05.2016.
 */
public class PlaceDto {
    private long id;
    private String title;
    private String description;
    private int latitude;
    private int longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

        PlaceDto placeDto = (PlaceDto) o;

        if (id != placeDto.id) return false;
        if (latitude != placeDto.latitude) return false;
        if (longitude != placeDto.longitude) return false;
        if (title != null ? !title.equals(placeDto.title) : placeDto.title != null) return false;
        return !(description != null ? !description.equals(placeDto.description) : placeDto.description != null);

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
        return "PlaceDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
