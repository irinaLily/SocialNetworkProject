package dao.impl;

import dao.PlaceDao;
import dao.entities.Place;
import dao.model.PlaceDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import static dao.converters.EntityDtoConverter.convert;
/**
 * Created by Ирина on 22.04.2016.
 */
@Repository
@Transactional
public class PlaceImpl  implements PlaceDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PlaceDto> findAll() {
        List<Place> places=sessionFactory.getCurrentSession().createQuery("from Place").list();
        List<PlaceDto> placeDtos=new ArrayList<>(places.size());
        for (Place place:places){
            placeDtos.add(convert(place));
        }
        return placeDtos;
    }

    @Override
    public PlaceDto findById(long id) {
        Place place=(Place) sessionFactory.getCurrentSession()
                .createQuery("select i from Place i where i.id=:id")
                .setParameter("id",id).uniqueResult();
        return convert(place);
    }

    @Override
    public PlaceDto findByTitle(String title) {
        List<Place> places= sessionFactory.getCurrentSession()
                .createQuery("select i from Place i where i.title=:title")
                .setParameter("title",title).list();

        return convert(places.get(0));
    }

    @Override
    @Transactional(readOnly = false)
    public long create(PlaceDto placeDto) {
        Place place=convert(placeDto);
        sessionFactory.getCurrentSession().save(place);
        return place.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(PlaceDto placeDto) {
        sessionFactory.getCurrentSession().save(convert(placeDto));
    }
}
