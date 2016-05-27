package dao.impl;

import dao.HobbyDao;
import dao.entities.Hobby;
import dao.model.HobbyDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import  static dao.converters.EntityDtoConverter.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
@Repository
@Transactional
public class HobbyImpl  implements HobbyDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<HobbyDto> findAll() {
        List<Hobby> hobbyList=sessionFactory.getCurrentSession().createQuery("from Hobby").list();
        List<HobbyDto> result=new ArrayList<>(hobbyList.size());
        for(Hobby hobby:hobbyList){
            result.add(convert(hobby));
        }
        return result;
    }

    @Override
    public HobbyDto findById(long id) {
        Hobby hobby=(Hobby) sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Hobby i WHERE i.id = :id")
                .setParameter("id",id).uniqueResult();
        return hobby==null? null:convert(hobby);
    }

    @Override
    public HobbyDto findByTitle(String title) {
        Hobby hobby=(Hobby) sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Hobby i WHERE i.title = :title")
                .setParameter("title",title).uniqueResult();
        return hobby==null? null:convert(hobby);
    }

    @Override
    public HobbyDto findByDescription(String description) {
        Hobby hobby=(Hobby) sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Hobby i WHERE i.description = :description")
                .setParameter("description",description).uniqueResult();
        return hobby==null? null:convert(hobby);
    }

    @Override
    @Transactional(readOnly = false)
    public long create(HobbyDto hobbyDto) {
        Hobby hobby=convert(hobbyDto);
        sessionFactory.getCurrentSession().save(hobby);
        return hobby.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(HobbyDto hobbyDto) {
        Hobby hobby=convert(hobbyDto);
        sessionFactory.getCurrentSession().saveOrUpdate(hobby);

    }
}
