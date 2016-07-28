package dao.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ирина on 04.05.2016.
 */
public class PersonDto {
    private Long id;
    private String firstNname;
    private String lastName;
    private LocalDate birthday;
    private String nicName;
    private List<PlaceDto> placeDtos;

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlaceDto> getPlaceDtos() {
        return placeDtos;
    }

    public void setPlaceDtos(List<PlaceDto> placeDtos) {
        this.placeDtos = placeDtos;
    }

    public Long getId() {
        return id;
    }
    

    public String getFirstNname() {
        return firstNname;
    }

    public void setFirstNname(String firstNname) {
        this.firstNname = firstNname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDto personDto = (PersonDto) o;

        if (id != personDto.id) return false;
        if (firstNname != null ? !firstNname.equals(personDto.firstNname) : personDto.firstNname != null) return false;
        if (lastName != null ? !lastName.equals(personDto.lastName) : personDto.lastName != null) return false;
        if (birthday != null ? !birthday.equals(personDto.birthday) : personDto.birthday != null) return false;
        return !(nicName != null ? !nicName.equals(personDto.nicName) : personDto.nicName != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstNname != null ? firstNname.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nicName != null ? nicName.hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstNname='" + firstNname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", nicName='" + nicName + '\'' +

                '}';
    }
}
