package dao.model;

import java.util.List;

/**
 * Created by Ирина on 04.05.2016.
 */
public class HobbyDto {
    private Long id;
    private String title;
    private String description;
    private List<PersonDto> personDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HobbyDto hobbyDto = (HobbyDto) o;

        if (id != hobbyDto.id) return false;
        if (title != null ? !title.equals(hobbyDto.title) : hobbyDto.title != null) return false;
        return !(description != null ? !description.equals(hobbyDto.description) : hobbyDto.description != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HobbyDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
