package dao.impl;

import dao.entities.HasID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ирина on 22.04.2016.
 */
public abstract class GenericDaoImpl <E extends HasID>/* implements GenericDao<E> */{
    private final Logger logger= LoggerFactory.getLogger("dao");
    private final AtomicLong counter=new AtomicLong(0);
    private final Map<Long,E> dataBase=new HashMap<>();

    public E save(E entity) {
        long id=counter.getAndIncrement();
        entity.setId(id);
        dataBase.put(id,entity);
        logger.info("stored entity e",entity);

        return entity;
    }


    public void update(E entity) {
        E ordinal=dataBase.get(entity.getId());
        if(ordinal==null){
            logger.info("not found",entity);
            return;
        }
        dataBase.put(entity.getId(),entity);
        logger.info("Entity was updated from {} to {}",ordinal,entity);
    }


    public void delete(E entity) {
        E delete=dataBase.remove(entity.getId());
        if (delete == null) {
            logger.info("Can't find entity to delete!");
        } else {
            logger.info("Entity {} deleted successfully!", entity);
        }


    }


    public E findById(long id) {
        E findEntity=dataBase.get(id);
        if(findEntity==null){
            logger.info("not founf for id",id);
            return null;
        }else {
            logger.info("find",findEntity);
           return findEntity;
        }
    }


    public List<E> findAll() {
        return new ArrayList<>(dataBase.values());
    }
    protected Map<Long, E> getDataBase() {
        return dataBase;
    }

    protected Logger getLogger() {
        return logger;
    }
}
