package dao.impl;

import dao.MessageDao;
import dao.entities.Message;
import dao.model.MessageDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static dao.converters.EntityDtoConverter.convert;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
@Repository
@Transactional
public class MessageImpl  implements MessageDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<MessageDto> findAll() {
        List<Message> messages=sessionFactory.getCurrentSession().createQuery("from Message").list();
        List<MessageDto>  messageDtos=new ArrayList<>(messages.size());
        for(Message message:messages){
            messageDtos.add(convert(message));
        }
        return messageDtos;
    }

    @Override
    public MessageDto findById(long id) {
        Message message=(Message)sessionFactory.getCurrentSession().createQuery("SELECT i FROM Message i WHERE i.id=:id")
                .setParameter("id",id).uniqueResult();
        return convert(message);
    }

    @Override
    public MessageDto findByContent(String content) {
        Message message = (Message) sessionFactory.getCurrentSession().createQuery("SELECT i FROM Message i WHERE i.content=:content")
                .setParameter("content", content).uniqueResult();
        return convert(message);
    }

    @Override
    @Transactional(readOnly = false)
    public long create(MessageDto messageDto) {
        Message message=convert(messageDto);
        sessionFactory.getCurrentSession().save(message);
        return message.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(MessageDto messageDto) {
        Message message=convert(messageDto);
        sessionFactory.getCurrentSession().saveOrUpdate(message);

    }

    @Override
    public List<MessageDto> findAllPersonFrom(Long id) {
        List<Message> messages = sessionFactory.getCurrentSession().createQuery("select i from Message i where i.personFrom.id=:id")
                .setParameter("id",id).list();
        List<MessageDto> messageDtos = new ArrayList<>(messages.size());
        for (Message message : messages) {
            System.out.println("messageImpl find person from "+message);
            messageDtos.add(convert(message));
        }
        return messageDtos;

    }
    @Override
    public List<MessageDto> findAllPersonTo(Long id) {
        List<Message> messages = sessionFactory.getCurrentSession().createQuery("select i from Message i where i.personTo.id=:id")
                .setParameter("id",id).list();
        List<MessageDto> messageDtos = new ArrayList<>(messages.size());
        for (Message message : messages) {
            messageDtos.add(convert(message));
        }
        return messageDtos;

    }

}
