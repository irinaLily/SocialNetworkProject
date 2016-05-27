package serviceCore.impl;

import dao.HobbyDao;
import dao.PlaceDao;
import dao.entities.Hobby;
import dao.entities.Person;
import dao.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceCore.InterestService;

import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
@Service
public class InterestServiceImpl implements InterestService {
    @Autowired
    private HobbyDao hobbyDao ;
    @Autowired
    private PlaceDao placeDao;

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    @Override
    public void addPlace(Place place) {

    }

    @Override
    public void addHobby(Hobby hobby) {

    }

    @Override
    public List<Person> getAllpeopleWithHobby() {
        return null;
    }

    @Override
    public List<Person> getAllpeopleFromPlace() {
        return null;
    }
}
