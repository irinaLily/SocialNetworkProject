package dao.model;

/**
 * Created by Ирина on 23.05.2016.
 */
public class PersonPlaceDto {
    private PlaceDto placeDto;
    private PersonDto personDto;

    public PlaceDto getPlaceDto() {
        return placeDto;
    }

    public void setPlaceDto(PlaceDto placeDto) {
        this.placeDto = placeDto;
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

        PersonPlaceDto that = (PersonPlaceDto) o;

        if (placeDto != null ? !placeDto.equals(that.placeDto) : that.placeDto != null) return false;
        return !(personDto != null ? !personDto.equals(that.personDto) : that.personDto != null);

    }

    @Override
    public int hashCode() {
        int result = placeDto != null ? placeDto.hashCode() : 0;
        result = 31 * result + (personDto != null ? personDto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonPlaceDto{" +
                "placeDto=" + placeDto.getId() +
                ", personDto=" + personDto.getId() +
                '}';
    }
}
