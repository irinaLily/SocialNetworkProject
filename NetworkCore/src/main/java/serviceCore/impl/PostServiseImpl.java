package serviceCore.impl;

import dao.MessageDao;
import dao.PersonDao;
import dao.PostDao;
import dao.PostLikesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ирина on 24.04.2016.
 */
@Service
public class PostServiseImpl {
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
}
