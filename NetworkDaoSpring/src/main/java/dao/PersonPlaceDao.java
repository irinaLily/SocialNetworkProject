package dao;

import dao.model.PersonPlaceDto;

import java.util.List;

/**
 * Created by Ирина on 24.05.2016.
 */
public interface PersonPlaceDao {
    List<PersonPlaceDto> findAll();


    List<PersonPlaceDto> findAllPerson(Long id);
    List<PersonPlaceDto> findAllPlace(Long id);
    List<PersonPlaceDto> findAllPlacePerson(Long idPerson,Long idPlace);

    long create(PersonPlaceDto personPlaceDto);
    void update(PersonPlaceDto personPlaceDto);
}
