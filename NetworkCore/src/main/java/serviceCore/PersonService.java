package serviceCore;

import dao.model.FriendshipDto;
import dao.model.PersonDto;

import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public interface PersonService {
    public long createPerson(PersonDto person);
    public boolean removePerson(PersonDto person);
    public PersonDto getPersonForId(long id);
    List<PersonDto> getALLPersons();
    List<FriendshipDto> getALLFriends(PersonDto personDto);
    public void addFriendship(FriendshipDto friendshipDto);

}
