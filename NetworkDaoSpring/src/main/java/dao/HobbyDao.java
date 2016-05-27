package dao;

import dao.model.HobbyDto;

import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface HobbyDao {
    List<HobbyDto> findAll();
    HobbyDto findById(long id);
    HobbyDto findByTitle(String title);
    HobbyDto findByDescription(String description);
    long create(HobbyDto hobbyDtoDto);
    void update(HobbyDto hobbyDtoDto);

}
