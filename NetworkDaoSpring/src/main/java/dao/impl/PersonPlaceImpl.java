package dao.impl;

import dao.PersonPlaceDao;
import dao.entities.PersonPlace;
import dao.model.PersonPlaceDto;
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
public class PersonPlaceImpl implements PersonPlaceDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PersonPlaceDto> findAll() {
        List<PersonPlace> personPlaces=sessionFactory.getCurrentSession()
                .createQuery("from PersonPlace ").list();
        List<PersonPlaceDto>  personPlaceDtos=new ArrayList<>(personPlaces.size());
        for(PersonPlace personPlace:personPlaces){
            personPlaceDtos.add(convert(personPlace));
        }
        return personPlaceDtos;
    }

    @Override
    public List<PersonPlaceDto> findAllPerson(Long id) {
        List<PersonPlace> personPlaces=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonPlace i where i.person.id=:id")
                .setParameter("id",id).list();
        List<PersonPlaceDto>  personPlaceDtos=new ArrayList<>(personPlaces.size());
        for(PersonPlace personPlace:personPlaces){
            personPlaceDtos.add(convert(personPlace));
        }
        return personPlaceDtos;
}

    @Override
    public List<PersonPlaceDto> findAllPlace(Long id) {
        List<PersonPlace> personPlaces=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonPlace i where i.place.id=:id")
                .setParameter("id",id).list();
        List<PersonPlaceDto>  personPlaceDtos=new ArrayList<>(personPlaces.size());
        for(PersonPlace personPlace:personPlaces){
            personPlaceDtos.add(convert(personPlace));
        }
        return personPlaceDtos;
    }

    @Override
    public List<PersonPlaceDto> findAllPlacePerson(Long idPerson, Long idPlace) {
        List<PersonPlace> personPlaces=sessionFactory.getCurrentSession()
                .createQuery("select i from PersonPlace i where i.place.id=:idPlace and i.person.id=:idPerson")
                .setParameter("idPerson",idPerson).setParameter("idPlace",idPlace).list();
        List<PersonPlaceDto>  personPlaceDtos=new ArrayList<>(personPlaces.size());
        for(PersonPlace personPlace:personPlaces){
            personPlaceDtos.add(convert(personPlace));
        }
        return personPlaceDtos;
    }
    @Transactional(readOnly = false)
    @Override
    public long create(PersonPlaceDto personPlaceDto) {
        PersonPlace personPlace=convert(personPlaceDto);
        sessionFactory.getCurrentSession().save(personPlace);
        return personPlace.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public long update(PersonPlaceDto personPlaceDto) {
        PersonPlace personPlace=convert(personPlaceDto);
        sessionFactory.getCurrentSession().saveOrUpdate(personPlace);
        return personPlace.getId();
    }
    @Override
    @Transactional(readOnly = false)
    public void remove(PersonPlaceDto personPlaceDto) {
        PersonPlace personPlace=convert(personPlaceDto);
        sessionFactory.getCurrentSession().delete(personPlace);

    }
}
