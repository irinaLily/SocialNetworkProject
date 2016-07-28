package serviceCore;

import com.google.gson.Gson;
import dao.HobbyDao;
import dao.model.FriendshipDto;
import dao.model.PersonDto;
import dao.model.PostDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/core.xml");
        InterestService interestService = context.getBean("interestService",InterestService.class);
        PersonService personService = context.getBean("personService",PersonService.class);
        PostService postService = context.getBean("postService",PostService.class);
//        System.out.println(interestService.getAllHobby());
//      System.out.println(interestService.getAllpeopleFromPlace(2l));
//        System.out.println(interestService.getAllPlaseForPerson(2L));
//        System.out.println(personService.getPersonForId(2L));
        PostDto postDto=new PostDto();
        postDto.setTitle("title");
        postDto.setContent("content");
        postDto.setPlase_time(LocalDate.of(2015,11,9));
        PersonDto personDto=personService.getPersonForId(2L);
        postDto.setPerson(personDto);
        postService.addPost(postDto);
        System.out.println(postService.getAllLPostForPerson(personDto));

//        System.out.println(personService.getPersonForNik("pIK"));

//        System.out.println(interestService.getHobbyForIdPerson(2L));
//        System.out.println(interestService.getAllpeopleWithHobby(2));

//        System.out.println(postService.getAllLikesForPost(1l));
//        System.out.println(postService.getAllLikesForPost(3L));


//        System.out.println(postService.getMessageForUser(2L));
//        System.out.println("************");
//        System.out.println(postService.getMyMessage(2L));


//        System.out.println(personService.getALLFriends(2L));

//        Long ii=personService.createPerson("Tom","Kruz",LocalDate.of(1970,10,11),"TomKruz");
//        System.out.println(interestService.getAllpeopleFromPlace(1L));
//        System.out.println(interestService.getAllpeopleWithHobby(2L));
//        System.out.println(interestService.getAllpeopleWithHobby(interestService.getHobbyForId(2)));
//       System.out.println(personService.getPersonForId(ii));
//        System.out.println(personService.getALLFriends(3));
      //??? personService.removePerson(3);
//        System.out.println(personService.getALLPersons());
//        personService.addFriendship(1,4);
       // personService.addFriendship(4,2);
//       System.out.println(personService.getALLFriends(1));
//       System.out.println(personService.getALLFriends(4));
       /* FriendshipDto friendshipDto=new FriendshipDto();
        friendshipDto.setFriendId(personService.getPersonForId(ii));

        friendshipDto.setPersonId(personService.getPersonForId(2));
        friendshipDto.setDataFrom(LocalDate.of(2015,1,2));
        personService.addFriendship(friendshipDto);*/
        Gson gson = context.getBean(Gson.class);
       // System.out.println(personService.getALLPersons());
     /*   FriendshipDto friendship=new FriendshipDto();
        friendship.setPersonId(personDao.findById(3));
        friendship.setFriendId(personDao.findById(2));
        friendship.setDataFrom(LocalDate.of(2015,05,10));
        friendshipDao.create(friendship);*/
//       System.out.println(friendshipDao.findPersonFriend(3,2));
      //  System.out.println(personService.getALLFriends(personService.getPersonForId(ii)));


       /*  System.out.println(interestService);
        System.out.println(personService);*/


        //fghfghfghfghfghfgh

    }
}
