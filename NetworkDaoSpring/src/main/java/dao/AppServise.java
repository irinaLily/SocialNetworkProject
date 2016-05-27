package dao;

import dao.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ирина on 14.05.2016.
 */
@Service
public class AppServise {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private MessageDao messageDao;

    @Transactional
    public List<MessageDto> findMessage(Long temp){
        List<MessageDto> messageDtos=new ArrayList<>();
        messageDtos=messageDao.findAllPersonFrom(temp);
        return messageDtos;
    }

}
