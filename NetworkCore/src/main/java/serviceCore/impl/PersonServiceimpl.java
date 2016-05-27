package serviceCore.impl;

import dao.FriendshipDao;
import dao.PersonDao;
import dao.model.FriendshipDto;
import dao.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceCore.PersonService;

import java.util.*;

/**
 * Created by Ирина on 24.04.2016.
 */
@Service
public class PersonServiceimpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private FriendshipDao friendshipDao;
   /* private Map<Person,Set<FriendshipDao>> personFriends=new HashMap<>();*/

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setFriendshipDao(FriendshipDao friendshipDao) {
        this.friendshipDao = friendshipDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public FriendshipDao getFriendshipDao() {
        return friendshipDao;
    }

    @Override
    public PersonDto getPersonForId(long id) {
        return  this.personDao.findById(id);

    }

    @Override
    public  List<PersonDto> getALLPersons() {

        return personDao.findAll();
    }

    @Override
    public long createPerson(PersonDto person) {
        long id=personDao.create(person);
        person.setId(id);
      return   id;

    }


    @Override
    public boolean removePerson(PersonDto person) {

        return false;
    }

    @Override
    public List<FriendshipDto> getALLFriends(PersonDto personDto) {
        if(personDto==null)
        {createPerson(personDto);}
        return friendshipDao.findAllFriend(personDto.getId());
    }

    @Override
    public void addFriendship(FriendshipDto friendshipDto) {
        friendshipDao.create(friendshipDto);

    }
}
