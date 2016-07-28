package serviceCore;

import dao.model.MessageDto;
import dao.model.PersonDto;
import dao.model.PostDto;
import dao.model.PostLikesDto;

import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public interface PostService {

    public  void addPost(PostDto postDto);
    public  void addPostLike(Long idPost,Long idPerson);
    public  void addPostLike(PostDto postDto,PersonDto personDto);
    public  void addMessage(MessageDto messageDto);
    public List<MessageDto> getAllpeopleFromMessage(PersonDto personDto);

    public  void removePostLike(Long idPost,Long idPerson);
    public  void removePost(PostDto postDto);
    public  void removeMessage(MessageDto messageDto);
    public  List<MessageDto> getLatestMessageForUser(PersonDto personDto);
    public  List<MessageDto> getLatestMessageForUser(Long idPerson);
    public  List<MessageDto> getMessageForUser(PersonDto personDto);
    public  List<MessageDto> getMessageForUser(Long idPerson);
    public  List<MessageDto> getMyMessage(Long idPerson);
    public  List<PostLikesDto> getAllLikesForPost(PostDto postDto);
    public  List<PostLikesDto> getAllLikesForPost(Long idpost);
    public  List<PostDto> getAllLPostForPerson(PersonDto personDto);
}
