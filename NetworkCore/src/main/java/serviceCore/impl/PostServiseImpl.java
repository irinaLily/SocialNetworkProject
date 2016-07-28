package serviceCore.impl;

import dao.MessageDao;
import dao.PersonDao;
import dao.PostDao;
import dao.PostLikesDao;
import dao.model.MessageDto;
import dao.model.PersonDto;
import dao.model.PostDto;
import dao.model.PostLikesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceCore.PostService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
@Service
public class PostServiseImpl implements PostService{
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private PostLikesDao postLikesDao;
    @Autowired
    private MessageDao messageDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public PostLikesDao getPostLikesDao() {
        return postLikesDao;
    }

    public void setPostLikesDao(PostLikesDao postLikesDao) {
        this.postLikesDao = postLikesDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void addPost(PostDto postDto) {
        if(postDto!=null){
            postDao.create(postDto);
        }

    }

    @Override
    public void addPostLike(Long idPost, Long idPerson) {

    }

    @Override
    public void addPostLike(PostDto postDto, PersonDto personDto) {

    }

    @Override
    public void addMessage(MessageDto messageDto) {

    }

    @Override
    public List<PostDto> getAllLPostForPerson(PersonDto personDto) {

        if(personDto!=null) {
            if(personDto.getId()!=null) {
                List<PostDto> postDtos=postDao.findPostByPerson(personDto.getId());
                for (PostDto postDto:postDtos){
                    List<PostLikesDto> postLikesDtoList=this.getAllLikesForPost(postDto.getId());
                    List<PersonDto> personDtos=new ArrayList<>(postLikesDtoList.size());
                    for (PostLikesDto postLikesDto:postLikesDtoList) {
                        personDtos.add(postLikesDto.getPersonId());
                    }
                    postDto.setPostLikesPerson(personDtos);
                }
                return postDtos;
            }else return Collections.emptyList();
        }
        else return Collections.emptyList();
    }




    @Override
    public List<MessageDto> getAllpeopleFromMessage(PersonDto personDto) {
        if(personDto!=null) {
            if(personDto.getId()!=0) {
                List<MessageDto> messageDtos=messageDao.findAllPersonFrom(personDto.getId());
                return messageDtos;
            }else return Collections.emptyList();
        }
        else return Collections.emptyList();
    }

    @Override
    public List<MessageDto> getLatestMessageForUser(PersonDto personDto) {
        if(personDto!=null) {
            if(personDto.getId()!=null) {
                List<MessageDto> messageDtos=messageDao.findAllPersonToLatest(personDto.getId());
                return messageDtos;
            }else return Collections.emptyList();
        }
        else return Collections.emptyList();
    }

    @Override
    public List<MessageDto> getLatestMessageForUser(Long idPerson) {
        if(idPerson!=null) {
            List<MessageDto> messageDtos=messageDao.findAllPersonToLatest(idPerson);
            return messageDtos;
        }else return Collections.emptyList();
    }

    @Override
    public List<MessageDto> getMessageForUser(PersonDto personDto) {
        if(personDto!=null) {
            if(personDto.getId()!=null) {
                List<MessageDto> messageDtos=messageDao.findAllPersonTo(personDto.getId());
                return messageDtos;
            }else return Collections.emptyList();
        }
        else return Collections.emptyList();
    }

    @Override
    public List<MessageDto> getMyMessage(Long idPerson) {
        if(idPerson!=null) {
            List<MessageDto> messageDtos=messageDao.findAllPersonFrom(idPerson);
            return messageDtos;
        }else return Collections.emptyList();

    }

    @Override
    public List<MessageDto> getMessageForUser(Long idPerson) {

            if(idPerson!=null) {
                List<MessageDto> messageDtos=messageDao.findAllPersonTo(idPerson);
                return messageDtos;
            }else return Collections.emptyList();

    }

    @Override
    public List<PostLikesDto> getAllLikesForPost(PostDto postDto) {
        return null;
    }

    @Override
    public List<PostLikesDto> getAllLikesForPost(Long idpost) {
        if(idpost!=null) {
            List<PostLikesDto> postLikesDtos=postLikesDao.findAllPost(idpost);
            return postLikesDtos;
        }else return Collections.emptyList();

    }

    @Override
    public void removePostLike(Long idPost, Long idPerson) {

    }

    @Override
    public void removePost(PostDto postDto) {

    }

    @Override
    public void removeMessage(MessageDto messageDto) {

    }


}
