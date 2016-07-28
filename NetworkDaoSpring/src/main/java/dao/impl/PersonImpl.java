package dao.impl;

import dao.PersonDao;
import dao.entities.Person;
import dao.model.PersonDto;
import dao.model.PostDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static dao.converters.EntityDtoConverter.convert;
/**
 * Created by Ирина on 22.04.2016.
 */
@Repository
@Transactional
public class PersonImpl  implements PersonDao {

   @Autowired
   private SessionFactory sessionFactory;

    @Override
    public List<PersonDto> findAll() {
        List<Person> persons=sessionFactory.getCurrentSession().createQuery("from Person ").list();
        List<PersonDto> personDtos=new ArrayList<>(persons.size());
        for(Person person:persons){
            personDtos.add(convert(person));
        }
        return personDtos;
    }

    @Override
    public PersonDto findById(long id) {
        Person person= (Person) sessionFactory.getCurrentSession().createQuery("SELECT i FROM Person i WHERE i.id=:id")
                .setParameter("id",id).uniqueResult();
        return person==null ? null : convert(person);
    }

    @Override
    public List<PersonDto> findByFierstName(String firstNname) {
        List<Person> persons=sessionFactory.getCurrentSession().createQuery("SELECT i FROM Person i WHERE i.firstNname=:firstNname")
                .setParameter("firstNname",firstNname).list();
        List<PersonDto> personDtos=new ArrayList<>(persons.size());
        for(Person person:persons){
            personDtos.add(convert(person));
        }
        return personDtos;
    }

    @Override
    public List<PersonDto> findByLastName(String lastName) {
        List<Person> persons=sessionFactory.getCurrentSession().createQuery("SELECT i FROM Person i WHERE i.lastName=:lastName")
                .setParameter("lastName",lastName).list();
        List<PersonDto> personDtos=new ArrayList<>(persons.size());
        for(Person person:persons){
            personDtos.add(convert(person));
        }
        return personDtos;
    }

    @Override
    public PersonDto findByNickname(String nicName) {
        Person person=(Person)sessionFactory.getCurrentSession().createQuery("SELECT i FROM Person i WHERE i.nicName=:nicName")
                .setParameter("nicName",nicName).uniqueResult();
        return person==null? null:convert(person);
    }

    @Override
    public PersonDto findByBirthday(LocalDate birthdat) {
        return null;
    }

    @Override
    public Set<PersonDto> findAllfriend() {
        return null;
    }



    @Override
    public Set<PostDto> findAllPost() {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public long create(PersonDto personDto) {
        Person person=convert(personDto);
        sessionFactory.getCurrentSession().save(person);
        return person.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public long update(PersonDto personDto) {
        Person person=convert(personDto);
        sessionFactory.getCurrentSession().saveOrUpdate(person);
        return person.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(PersonDto personDto) {
        Person person=convert(personDto);
        sessionFactory.getCurrentSession().delete(person);
    }
}
