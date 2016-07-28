package serviceCore;

import dao.entities.Hobby;
import dao.entities.Person;
import dao.entities.Place;
import dao.model.HobbyDto;
import dao.model.PersonDto;
import dao.model.PlaceDto;

import java.util.List;

/**
 * Created by Ирина on 24.04.2016.
 */
public interface InterestService {
    public  void addPlace(PlaceDto place,PersonDto personDto);
    public  void addPlace(Long idPlace,Long idPerson);
    public  void addHobby(HobbyDto hobby,PersonDto personDto);
    public  void addHobby(Long idHobby,Long idPerson);
    public List<PersonDto> getAllpeopleWithHobby(HobbyDto hobby);
    public List<PersonDto> getAllpeopleWithHobby(Long idhobby);
    public List<PersonDto> getAllpeopleLikesPerson(Long idPerson);
    public List<PersonDto> getAllpeopleFromPlace(PlaceDto placeDto);
    public List<PersonDto> getAllpeopleFromPlace(Long idplace);
    public HobbyDto getHobbyForId(Long idHobby);
    public List< HobbyDto> getHobbyForIdPerson(Long idPerson);
    public List< HobbyDto> getAllHobby();
    public List<PersonDto> getPersonWithHobby(Long idPerson);
    public PlaceDto getPlaceForId(Long idPlace);
    public List<PlaceDto> getAllPlaseForPerson(Long idPerson);

}
