package dao.impl;

import dao.PersonHobbyDao;
import dao.entities.PersonHobby;
import dao.model.PersonHobbyDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static dao.converters.EntityDtoConverter.convert;

/**
 * Created by Ирина on 24.05.2016.
 */
@Repository
@Transactional
public class PersonHobbyImpl implements PersonHobbyDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PersonHobbyDto> findAll() {
        List<PersonHobby> personHobbies=sessionFactory.getCurrentSession()
                .createQuery("from PersonHobby ").list();
        List<PersonHobbyDto>  personPlaceDtos=new ArrayList<>(personHobbies.size());
        for(PersonHobby personHobby:personHobbies){
            personPlaceDtos.add(convert(personHobby));
        }
        return personPlaceDtos;
    }

    @Override
    public List<PersonHobbyDto> findAllPerson(Long id) {
        List<PersonHobby> personHobbies=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonHobby i where i.person.id=:id")
                .setParameter("id",id).list();
        List<PersonHobbyDto>  personPlaceDtos=new ArrayList<>(personHobbies.size());
        for(PersonHobby personHobby:personHobbies){
            personPlaceDtos.add(convert(personHobby));
        }
        return personPlaceDtos;
    }


    @Override
    public List<PersonHobbyDto> findAllHobby(Long id) {
        List<PersonHobby> personHobbies=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonHobby i where i.hobby.id=:id")
                .setParameter("id",id).list();
        List<PersonHobbyDto>  personPlaceDtos=new ArrayList<>(personHobbies.size());
        for(PersonHobby personHobby:personHobbies){
            personPlaceDtos.add(convert(personHobby));
        }
        return personPlaceDtos;
    }

    @Override
    public List<PersonHobbyDto> findAllHobbyPerson(Long idPerson, Long idHobby) {
        List<PersonHobby> personHobbies=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonHobby i where i.hobby.id=:idHobby and i.person.id=:idPerson")
                .setParameter("idPerson",idPerson).setParameter("idHobby",idHobby).list();
        List<PersonHobbyDto>  personPlaceDtos=new ArrayList<>(personHobbies.size());
        for(PersonHobby personHobby:personHobbies){
            personPlaceDtos.add(convert(personHobby));
        }
        return personPlaceDtos;
    }


    @Override
    @Transactional(readOnly = false)
    public long create(PersonHobbyDto personHobbyDto) {
        PersonHobby personHobby=convert(personHobbyDto);
        sessionFactory.getCurrentSession().save(personHobby);
        return personHobby.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(PersonHobbyDto personHobbyDto) {
        PersonHobby personHobby=convert(personHobbyDto);
        sessionFactory.getCurrentSession().saveOrUpdate(personHobby);
    }
}
