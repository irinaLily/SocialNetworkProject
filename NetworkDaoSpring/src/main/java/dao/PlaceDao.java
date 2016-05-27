package dao;

import dao.model.PlaceDto;

import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface PlaceDao  {
    List<PlaceDto> findAll();
    PlaceDto findById(long id);
    PlaceDto findByTitle(String title);
    long create(PlaceDto placeDto);
    void update(PlaceDto placeDto);

}
