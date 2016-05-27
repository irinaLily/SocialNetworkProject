package dao;

import dao.model.PersonDto;
import dao.model.PostDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface PersonDao  {
    List<PersonDto> findAll();
    PersonDto findById(long id);
    PersonDto findByFierstName(String fierstName);
    PersonDto findByLastName(String lastName);
    PersonDto findByNickname(String nickname);
    PersonDto findByBirthday(LocalDate birthdat);
    Set<PersonDto> findAllfriend();

    Set<PostDto> findAllPost();
    long create(PersonDto personDto);
    void update(PersonDto personDto);
}
