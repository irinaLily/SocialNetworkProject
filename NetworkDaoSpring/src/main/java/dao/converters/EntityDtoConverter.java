package dao.converters;

import dao.model.*;
import dao.entities.*;

/**
 * Created by Ирина on 04.05.2016.
 */
public final class EntityDtoConverter {
    private EntityDtoConverter() {
    }
    public static Friendship convert(FriendshipDto friendshipDto) {
        if (friendshipDto == null) {
            return null;
        }
        Friendship friendship = new Friendship();
        friendship.setId((friendshipDto.getId()));
        friendship.setPersonId(convert(friendshipDto.getPersonId()));
        friendship.setFriendId(convert(friendshipDto.getFriendId()));
        friendship.setDataFrom(friendshipDto.getDataFrom());
        return friendship;
    }
    public static FriendshipDto convert(Friendship friendship){
        if(friendship==null){
            return null;
        }
        FriendshipDto friendshipDto=new FriendshipDto();
        friendshipDto.setId(friendship.getId());
        friendshipDto.setPersonId(convert(friendship.getPersonId()));
        friendshipDto.setFriendId(convert(friendship.getFriendId()));
        friendshipDto.setDataFrom(friendship.getDataFrom());
        return friendshipDto;
    }


    public static Hobby convert(HobbyDto hobbyDto){
        if(hobbyDto==null){
            return null;
        }
        Hobby hobby=new Hobby();
        hobby.setId(hobbyDto.getId());
        hobby.setTitle(hobbyDto.getTitle());
        hobby.setDescription(hobbyDto.getDescription());
        return hobby;
    }
    public static HobbyDto convert(Hobby hobby){
      if (hobby==null){
          return null;
      }
          HobbyDto hobbyDto=new HobbyDto();
          hobbyDto.setId(hobby.getId());
          hobbyDto.setTitle(hobby.getTitle());
          hobbyDto.setDescription(hobby.getDescription());
          return hobbyDto;

    }
    public static PlaceDto convert(Place place){
        if (place==null){
            return null;
        }
        PlaceDto placeDto=new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setTitle(place.getTitle());
        placeDto.setDescription(place.getDescription());
        placeDto.setLatitude(place.getLatitude());
        placeDto.setLongitude(place.getLongitude());
        return placeDto;

    }

    public static Place convert(PlaceDto placeDto){
        if (placeDto==null){
            return null;
        }
        Place place=new Place();
        place.setId(placeDto.getId());
        place.setTitle(placeDto.getTitle());
        place.setDescription(placeDto.getDescription());
        place.setLatitude(placeDto.getLatitude());
        place.setLongitude(placeDto.getLongitude());
        return place;

    }
    public static Message convert(MessageDto messageDto){
        if(messageDto==null){
            return null;
        }
        Message message=new Message();
        message.setId(messageDto.getId());
        message.setContent(messageDto.getContent());
        message.setTimeSent(messageDto.getTimeSent());
        System.out.println("messageDto.getPersonFrom()"+messageDto.getPersonFrom());
        message.setPersonFrom(convert(messageDto.getPersonFrom()));
        message.setPersonTo(convert(messageDto.getPersonTo()));
        return message;
    }
    public static MessageDto convert(Message message){
        if(message==null){
            return null;
        }
        MessageDto messageDto=new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setContent(message.getContent());
        messageDto.setTimeSent(message.getTimeSent());
        System.out.println("message.getPersonFrom())"+message.getPersonFrom());
        messageDto.setPersonFrom(convert(message.getPersonFrom()));
        messageDto.setPersonTo(convert(message.getPersonTo()));
        return messageDto;
    }
    public static PostLikes convert(PostLikesDto postlikesDto){
        if (postlikesDto==null){
            return null;
        }
        PostLikes postLikes=new PostLikes();
        postLikes.setPostId(convert(postlikesDto.getPostId()));
        postLikes.setPersonId(convert(postlikesDto.getPersonId()));
        return postLikes;
    }

    public static PostLikesDto convert(PostLikes postlikes){
        if(postlikes==null){
            return null;
        }
        PostLikesDto postLikesDto=new PostLikesDto();
        postLikesDto.setPostId(convert(postlikes.getPostId()));
        postLikesDto.setPersonId(convert(postlikes.getPersonId()));
        return postLikesDto;
    }

    public static Post convert(PostDto postDto){
        if (postDto==null){
            return null;
        }
        Post post=new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setPlase_time(postDto.getPlase_time());
        post.setPerson((convert(postDto.getPerson())));
       /* Set<PostLikes> postLikesSet=new HashSet<>();
        for (PostLikesDto  postlikesDto:postDto.getPostLikesSet()){
             postLikesSet.add(convert(postlikesDto));
        }
        post.setPostLikesSet(postLikesSet);*/
        return post;
    }


    public static PostDto convert(Post post){
        if (post==null){
            return null;
        }
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPlase_time(post.getPlase_time());
        postDto.setPerson(convert(post.getPerson()));

        return postDto;
    }

    public static Person convert(PersonDto personDto){
        if(personDto==null){
            return null;
        }
        Person person=new Person();
        System.out.println("personDto.getId()"+personDto.getId());
        person.setId(personDto.getId());
        person.setFirstNname(personDto.getFirstNname());
        person.setLastName(personDto.getLastName());
        person.setBirthday(personDto.getBirthday());
        person.setNicName(personDto.getNicName());
        return person;
    }

    public static PersonDto convert(Person person) {
        if (person == null) {
            return null;
        }
        PersonDto personDto = new PersonDto();
        System.out.println("person.getId()" + person.getId());
        personDto.setId(person.getId());
        personDto.setFirstNname(person.getFirstNname());
        personDto.setNicName(person.getNicName());
        personDto.setLastName(person.getLastName());
        personDto.setBirthday(person.getBirthday());

            return personDto;
        }

     public static PersonPlace convert(PersonPlaceDto personPlaceDto){
         if (personPlaceDto==null){
             return null;
         }
         PersonPlace personPlace=new PersonPlace();
         personPlace.setPlace(convert(personPlaceDto.getPlaceDto()));
         personPlace.setPerson(convert(personPlaceDto.getPersonDto()));
         return personPlace;
     }

    public static PersonPlaceDto convert(PersonPlace personPlace){
        if(personPlace==null){
            return null;
        }
        PersonPlaceDto personPlaceDto=new PersonPlaceDto();
        personPlaceDto.setPlaceDto(convert(personPlace.getPlace()));
        personPlaceDto.setPersonDto(convert(personPlace.getPerson()));
        return personPlaceDto;
    }

    public static PersonHobby convert(PersonHobbyDto personHobbyDto){
        if (personHobbyDto==null){
            return null;
        }
        PersonHobby personHobby=new PersonHobby();
        personHobby.setHobby(convert(personHobbyDto.getHobbyDto()));
        personHobby.setPerson(convert(personHobbyDto.getPersonDto()));
        return personHobby;
    }

    public static PersonHobbyDto convert(PersonHobby personHobby){
        if(personHobby==null){
            return null;
        }
        PersonHobbyDto personHobbyDto=new PersonHobbyDto();
        personHobbyDto.setHobbyDto(convert(personHobby.getHobby()));
        personHobbyDto.setPersonDto(convert(personHobby.getPerson()));
        return personHobbyDto;
    }


}