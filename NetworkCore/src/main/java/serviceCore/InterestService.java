package serviceCore;

import dao.entities.Hobby;
import dao.entities.Person;
import dao.entities.Place;

import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public interface InterestService {
    public  void addPlace(Place place);
    public  void addHobby(Hobby hobby);
    public List<Person> getAllpeopleWithHobby();
    public List<Person> getAllpeopleFromPlace();

}
