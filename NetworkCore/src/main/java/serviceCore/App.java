package serviceCore;

import com.google.gson.Gson;
import dao.model.FriendshipDto;
import dao.model.PersonDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

/**
 * Created by Ирина on 24.04.2016.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/core.xml");
        InterestService interestService = context.getBean("interestService",InterestService.class);
        PersonService personService = context.getBean("personService",PersonService.class);
        PersonDto person=new PersonDto();

        person.setLastName("Bonddddd");
        person.setFirstNname("ddddddd");
        person.setNicName("nigggggggggggggki");
        person.setBirthday(LocalDate.of(2001,9,5));

        long ii=personService.createPerson(person);
        FriendshipDto friendshipDto=new FriendshipDto();
        friendshipDto.setFriendId(personService.getPersonForId(ii));

        friendshipDto.setPersonId(personService.getPersonForId(2));
        friendshipDto.setDataFrom(LocalDate.of(2015,1,2));
        personService.addFriendship(friendshipDto);
        Gson gson = context.getBean(Gson.class);
       // System.out.println(personService.getALLPersons());
     /*   FriendshipDto friendship=new FriendshipDto();
        friendship.setPersonId(personDao.findById(3));
        friendship.setFriendId(personDao.findById(2));
        friendship.setDataFrom(LocalDate.of(2015,05,10));
        friendshipDao.create(friendship);*/
//       System.out.println(friendshipDao.findPersonFriend(3,2));
        System.out.println(personService.getALLFriends(personService.getPersonForId(ii)));


       /*  System.out.println(interestService);
        System.out.println(personService);*/

    }
}
