package serviceCore.impl;

import dao.*;
import dao.entities.Hobby;
import dao.entities.Person;
import dao.entities.Place;
import dao.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceCore.InterestService;

import java.util.ArrayList;
import java.util.Collections;
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
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonPlaceDao personPlaceDao;
    @Autowired
    private PersonHobbyDao personHobbyDao;


    public PersonPlaceDao getPersonPlaceDao() {
        return personPlaceDao;
    }

    public void setPersonPlaceDao(PersonPlaceDao personPlaceDao) {
        this.personPlaceDao = personPlaceDao;
    }

    public PersonHobbyDao getPersonHobbyDao() {
        return personHobbyDao;
    }

    public void setPersonHobbyDao(PersonHobbyDao personHobbyDao) {
        this.personHobbyDao = personHobbyDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

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
    public void addPlace(PlaceDto place, PersonDto personDto) {
        if(place!=null && personDto!=null) {
            long id = placeDao.update(place);
            place.setId(id);
            PersonPlaceDto personPlaceDto = new PersonPlaceDto();
            personPlaceDto.setPersonDto(personDto);
            personPlaceDto.setPlaceDto(place);
            long idPersonnPlace = personPlaceDao.create(personPlaceDto);
            personPlaceDto.setId(idPersonnPlace);
        }
    }

    @Override
    public void addPlace(Long idPlace, Long idPerson) {
        if(idPlace!=null && idPerson!=null) {
            PersonPlaceDto personPlaceDto = new PersonPlaceDto();
            personPlaceDto.setPersonDto(personDao.findById(idPerson));
            personPlaceDto.setPlaceDto(placeDao.findById(idPlace));
            long idPersonnPlace = personPlaceDao.create(personPlaceDto);
            personPlaceDto.setId(idPersonnPlace);
        }
    }

    @Override
    public void addHobby(HobbyDto hobby, PersonDto personDto) {
        if(hobby!=null&&personDto!=null){
            long id=hobbyDao.update(hobby);
            hobby.setId(id);
            PersonHobbyDto personHobbyDto=new PersonHobbyDto();
            personHobbyDto.setPersonDto(personDto);
            personHobbyDto.setHobbyDto(hobby);
            personHobbyDto.setId(personHobbyDao.create(personHobbyDto));
        }

    }

    @Override
    public void addHobby(Long idHobby, Long idPerson) {
        if(idHobby!=null&&idPerson!=null){
            PersonHobbyDto personHobbyDto=new PersonHobbyDto();
            personHobbyDto.setPersonDto(personDao.findById(idPerson));
            personHobbyDto.setHobbyDto(hobbyDao.findById(idHobby));
            personHobbyDto.setId(personHobbyDao.create(personHobbyDto));
        }

    }

    @Override
    public List<PersonDto> getAllpeopleWithHobby(HobbyDto hobby) {
        if(hobby!=null) {
            if(hobby.getId()!=null) {
                List<PersonDto> personDtoList=new ArrayList<>();
                List<PersonHobbyDto> personHobbyDtos=personHobbyDao.findAllHobby(hobby.getId());

                for (PersonHobbyDto personHobbyDto:personHobbyDtos){
                    personDtoList.add(personHobbyDto.getPersonDto());
                }
                return personDtoList;
            }else return Collections.emptyList();
        }
       else return Collections.emptyList();
    }

    @Override
    public List<PersonDto> getAllpeopleWithHobby(Long idhobby) {
        if(idhobby!=null) {
                List<PersonDto> personDtoList=new ArrayList<>();
                List<PersonHobbyDto> personHobbyDtos=personHobbyDao.findAllHobby(idhobby);

                for (PersonHobbyDto personHobbyDto:personHobbyDtos){
                    personDtoList.add(personHobbyDto.getPersonDto());
                }
                return personDtoList;
            }else return Collections.emptyList();

    }

    @Override
    public HobbyDto getHobbyForId(Long id) {
        if(id==null){
        return null;
        }else return hobbyDao.findById(id);
    }

    @Override
    public PlaceDto getPlaceForId(Long idPlace) {
        if(idPlace==0){
            return null;
        }else return placeDao.findById(idPlace);
    }

    @Override
    public List<PersonDto> getAllpeopleLikesPerson(Long idPerson) {
        return null;
    }

    @Override
    public List< HobbyDto> getHobbyForIdPerson(Long idPerson) {
        if(idPerson!=null) {
            List<PersonHobbyDto> personHobbyDtos=personHobbyDao.findAllPerson(idPerson);
            List<HobbyDto> hobbyDtos=new ArrayList<>(personHobbyDtos.size());
            for (PersonHobbyDto personHobbyDto:personHobbyDtos) {
                hobbyDtos.add(personHobbyDto.getHobbyDto());
            }
            return hobbyDtos;
        }else return Collections.emptyList();

    }
    @Override
    public List<PersonDto> getAllpeopleFromPlace(Long idplace) {
        if (idplace != null) {
            List<PersonDto> personDtoList = new ArrayList<>();
            List<PersonPlaceDto> personPlaceDtos = personPlaceDao.findAllPlace(idplace);
            for (PersonPlaceDto personPlaceDto : personPlaceDtos) {
                personDtoList.add(personPlaceDto.getPersonDto());
            }
            PlaceDto placeDto=placeDao.findById(idplace);
            placeDto.setPersonDtos(personDtoList);
            return personDtoList;
        } else return Collections.emptyList();
    }

    @Override
    public List<PersonDto> getAllpeopleFromPlace(PlaceDto placeDto) {
        if (placeDto != null) {
            if (placeDto.getId() != null) {
                List<PersonDto> personDtoList = new ArrayList<>();
                List<PersonPlaceDto> personPlaceDtos = personPlaceDao.findAllPlace(placeDto.getId());

                for (PersonPlaceDto personPlaceDto : personPlaceDtos) {
                    personDtoList.add(personPlaceDto.getPersonDto());
                }
                placeDto.setPersonDtos(personDtoList);
                return personDtoList;
            } else return Collections.emptyList();
        } else return Collections.emptyList();
    }

    @Override
    public List<PersonDto> getPersonWithHobby(Long idPerson) {
        return null;
    }

    @Override
    public List<PlaceDto> getAllPlaseForPerson(Long idPerson) {
        if (idPerson != null) {
            List<PlaceDto> placeDtos = new ArrayList<>();
            List<PersonPlaceDto> personPlaceDtos = personPlaceDao.findAllPerson(idPerson);
            for (PersonPlaceDto personPlaceDto : personPlaceDtos) {
                placeDtos.add(personPlaceDto.getPlaceDto());
            }
            PersonDto personDto=personDao.findById(idPerson);
            personDto.setPlaceDtos(placeDtos);
            for (PlaceDto placeDto:placeDtos){
                getAllpeopleFromPlace(placeDto);
            }
            return placeDtos;
        } else return Collections.emptyList();
    }

    @Override
    public List<HobbyDto> getAllHobby() {
        List<HobbyDto> hobbyDtos=hobbyDao.findAll();
        if(hobbyDtos.isEmpty()) {
            return null;
        }else{
            for (HobbyDto hobbyDto:hobbyDtos){
                List<PersonDto> personDtos=getAllpeopleWithHobby(hobbyDto);
                hobbyDto.setPersonDtos(personDtos);
            }
            return hobbyDtos;
        }
    }
}
