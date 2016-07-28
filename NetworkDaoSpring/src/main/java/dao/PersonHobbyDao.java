package dao;

import dao.model.PersonHobbyDto;

import java.util.List;

/**
 * Created by Ирина on 24.05.2016.
 */
public interface PersonHobbyDao {
    List<PersonHobbyDto> findAll();


    List<PersonHobbyDto> findAllPerson(Long id);
    List<PersonHobbyDto> findAllHobby(Long id);
    List<PersonHobbyDto> findAllHobbyPerson(Long idPerson,Long idHobby);

    long create(PersonHobbyDto personHobbyDto);
    long update(PersonHobbyDto personHobbyDto);
    void remove(PersonHobbyDto personHobbyDto);
}
