package serviceCore.impl;

import dao.FriendshipDao;
import dao.PersonDao;
import dao.entities.Person;
import dao.model.FriendshipDto;
import dao.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceCore.PersonService;

import java.time.LocalDate;
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
    public PersonDto getPersonForId(Long id) {
        if(id==null){
            return null;}
        else {
            return this.personDao.findById(id);
        }
    }

    @Override
    public PersonDto getPersonForNik(String nikName) {
        if(nikName==null){
            return null;}
        else {
            return this.personDao.findByNickname(nikName);
        }
    }

    @Override
    public  List<PersonDto> getALLPersons() {
        return personDao.findAll();
    }

    @Override
    public long createPerson(String firstNname, String lastName, LocalDate birthday, String nicName) {
        PersonDto personDto=new PersonDto();
        personDto.setFirstNname(firstNname);
        personDto.setLastName(lastName);
        personDto.setBirthday(birthday);
        personDto.setNicName(nicName);
        personDto.setId((Long)personDao.create(personDto));
        return  personDto.getId();
    }

    @Override
    public void removePerson(Long id) {
        if(id!=null) {
            PersonDto person = personDao.findById(id);
            personDao.remove(person);
        }
    }

    @Override
    public void updatePerson(PersonDto person) {
        if(person!=null) {
            personDao.update(person);
        }
    }

    @Override
    public void removePerson(PersonDto person) {
        personDao.remove(person);
    }

    @Override
    public List<PersonDto> getALLFriends(Long id) {
        if(id==null) {return null;}
        else{

            List<FriendshipDto> friendshipDtos= friendshipDao.findAllPerson(this.personDao.findById(id).getId());
            List<PersonDto> personDtos=new ArrayList<>(friendshipDtos.size());
            for (FriendshipDto friendshipDto:friendshipDtos){
                personDtos.add(friendshipDto.getFriendId());
            }
        return personDtos; }

    }


    @Override
    public void addFriendship(Long idPerson, Long idFriend) {
        if(idFriend!=null&&idPerson!=null){
        FriendshipDto friendship=new FriendshipDto();
        friendship.setPersonId(personDao.findById(idPerson));
        friendship.setFriendId(personDao.findById(idFriend));
        friendship.setDataFrom(LocalDate.now());
        friendship.setId(friendshipDao.create(friendship));
         System.out.println(friendshipDao.findPersonFriend(idPerson,idFriend));
        }

    }
}
