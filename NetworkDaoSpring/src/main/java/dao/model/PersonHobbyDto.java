package dao.model;

/**
 * Created by Ирина on 24.05.2016.
 */
public class PersonHobbyDto {
    private Long id;
    private HobbyDto hobbyDto;
    private PersonDto personDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HobbyDto getHobbyDto() {
        return hobbyDto;
    }

    public void setHobbyDto(HobbyDto hobbyDto) {
        this.hobbyDto = hobbyDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonHobbyDto that = (PersonHobbyDto) o;

        if (hobbyDto != null ? !hobbyDto.equals(that.hobbyDto) : that.hobbyDto != null) return false;
        return !(personDto != null ? !personDto.equals(that.personDto) : that.personDto != null);

    }

    @Override
    public int hashCode() {
        int result = hobbyDto != null ? hobbyDto.hashCode() : 0;
        result = 31 * result + (personDto != null ? personDto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonHobbyDto{" +
                "hobbyDto=" + hobbyDto.getId() +
                ", personDto=" + personDto.getId() +
                '}';
    }
}
