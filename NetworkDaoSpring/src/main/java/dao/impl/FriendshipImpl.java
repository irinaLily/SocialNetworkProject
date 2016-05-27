package dao.impl;

import dao.FriendshipDao;
import dao.entities.Friendship;
import dao.model.FriendshipDto;
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
public class FriendshipImpl implements FriendshipDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<FriendshipDto> findAll() {
        List<Friendship> friendships=sessionFactory.getCurrentSession().createQuery("from Friendship").list();
        List<FriendshipDto>  friendshipDtos=new ArrayList<>(friendships.size());
        for(Friendship friendship:friendships){
            friendshipDtos.add(convert(friendship));
        }
        return friendshipDtos;
    }

    @Override
    public List<FriendshipDto> findAllPerson(Long id) {
        List<Friendship> friendships=sessionFactory.getCurrentSession().createQuery("select i from Friendship i where i.personId.id=:id")
                .setParameter("id",id).list();
        List<FriendshipDto>  friendshipDtos=new ArrayList<>(friendships.size());
        for(Friendship friendship:friendships){
            friendshipDtos.add(convert(friendship));
        }
        return friendshipDtos;
    }

    @Override
    public List<FriendshipDto> findAllFriend(Long id) {
        List<Friendship> friendships=sessionFactory.getCurrentSession().createQuery("select i from Friendship i where i.friendId.id=:id")
                .setParameter("id",id).list();
        List<FriendshipDto>  friendshipDtos=new ArrayList<>(friendships.size());
        for(Friendship friendship:friendships){
            friendshipDtos.add(convert(friendship));
        }
        return friendshipDtos;
    }

    @Override
    public FriendshipDto findPersonFriend(long idPerson, long idFriend) {
        List<Friendship> friendships =sessionFactory.getCurrentSession()
                .createQuery("select i from Friendship i where i.friendId.id=:idFriend and i.personId.id=:idPerson")
                .setParameter("idPerson",idPerson).setParameter("idFriend",idFriend).list();
        if(friendships.isEmpty()){return null;}
        else {
            FriendshipDto friendshipDto = convert(friendships.get(0));
            return friendshipDto;
        }
    }

    @Override
    @Transactional(readOnly = false)
    public long create(FriendshipDto friendshipDto) {
        Friendship friendship=convert(friendshipDto);
        sessionFactory.getCurrentSession().save(friendship);
        return friendship.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(FriendshipDto friendshipDto) {
        Friendship friendship=convert(friendshipDto);
        sessionFactory.getCurrentSession().saveOrUpdate(friendship);

    }
}
