package serviceCore;

import dao.model.FriendshipDto;
import dao.model.PersonDto;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public interface PersonService {
    public long createPerson(String firstNname,String lastName,LocalDate birthday,String nicName);
    public void removePerson(PersonDto person);
    public void removePerson(Long id);
    public void updatePerson(PersonDto person);

    public PersonDto getPersonForId(Long id);
    public PersonDto getPersonForNik(String nik);
    List<PersonDto> getALLPersons();
    List<PersonDto> getALLFriends(Long id);
    public void addFriendship(Long idPerson,Long idFriend);


}
