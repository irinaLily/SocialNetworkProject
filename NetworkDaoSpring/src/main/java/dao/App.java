package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ирина on 23.04.2016.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/dao.xml");
        AppServise servise=context.getBean(AppServise.class);
       /* GenericDao<Person> person = context.getBean("personDao", GenericDao.class);
        System.out.println(person.findAll());*/
        PersonDao personDao=context.getBean("personDao",PersonDao.class);
        FriendshipDao friendshipDao=context.getBean("friendshipDao",FriendshipDao.class);
        MessageDao messageDao=context.getBean("messageDao",MessageDao.class);
       HobbyDao hobbyDao=context.getBean("hobbyDao",HobbyDao.class);
        PostDao postDao=context.getBean("postDao",PostDao.class);
        PostLikesDao postLikesDao=context.getBean("postLikesDao",PostLikesDao.class);
        PlaceDao placeDao=context.getBean("placeDao",PlaceDao.class);
        PersonPlaceDao personPlaceDao=context.getBean("personPlaceDao",PersonPlaceDao.class);
        PersonHobbyDao personHobbyDao=context.getBean("personHobbyDao",PersonHobbyDao.class);
        //System.out.println(personHobbyDao.findAll());
        System.out.println(personHobbyDao.findAllHobby(2l));
       // System.out.println(personPlaceDao.findAll());
        //System.out.println(personPlaceDao.findAllPerson(2L));
        //System.out.println(personPlaceDao.findAllPlacePerson(2L,1L));
        //System.out.println(placeDao.findAll());
        //System.out.println(placeDao.findByTitle("Lvov"));

       // System.out.println(postLikesDao.findAllPostPerson(3L,1L));
        //System.out.println(personDao.findById(1).getPersonFriends());
       // System.out.println(personDao.findByNickname("pIK").getPostLikesSet());
//        PostDto postDto=postDao.findById(2);
//        postDto.setTitle("dansing");
//        postDao.update(postDto);
        //System.out.println(postDao.findById(3).getPersons());
        //System.out.println(postDao.findByTitle("run"));

      // PostDao postDao=context.getBean("postDao",PostDao.class);
      //  System.out.println(postDao.findAll());
      // System.out.println(postDao.findPostByPerson(2));
        //System.out.println(hobbyDao.findAll());

        //System.out.println(friendshipDao.findAll());

     /*   FriendshipDto friendship=new FriendshipDto();
        friendship.setPersonId(personDao.findById(3));
        friendship.setFriendId(personDao.findById(2));
        friendship.setDataFrom(LocalDate.of(2015,05,10));
        friendshipDao.create(friendship);
        System.out.println(friendshipDao.findPersonFriend(3,2));*/

        //System.out.println(messageDao.findAllPersonTo(1L));
        //??? System.out.println(messageDao.findAllPersonFrom(2L));
        //System.out.println(servise.findMessage(lon));
        //System.out.println(messageDao.findById(1));

       // PersonDto personDto=personDao.findByFierstName("Jon");
        //System.out.println(personDto.getMessageSetFrom());

       // System.out.println(messageDao.findAll());
       // System.out.println(personDao.findAll());
       /* System.out.println(personDao.findByFierstName("Jon"));

        System.out.println(personDao.findByNickname("pIK"));
        System.out.println(personDao.findById(3));
        System.out.println(personDao.findByLastName("Hokigit"));*/
    }
}
