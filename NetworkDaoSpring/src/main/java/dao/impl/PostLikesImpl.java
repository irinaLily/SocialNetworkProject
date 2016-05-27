package dao.impl;

import dao.PostLikesDao;
import dao.entities.PostLikes;
import dao.model.PostLikesDto;
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
public class PostLikesImpl implements PostLikesDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PostLikesDto> findAll() {
        List<PostLikes> postLikes=sessionFactory.getCurrentSession().createQuery("from PostLikes").list();
        List<PostLikesDto>  postLikesDtos=new ArrayList<>(postLikes.size());
        for(PostLikes postLikes1:postLikes){
            postLikesDtos.add(convert(postLikes1));
        }
        return postLikesDtos;
    }

    @Override
    public List<PostLikesDto> findAllPerson(Long id) {
        List<PostLikes> postLikes=sessionFactory.getCurrentSession()
                .createQuery("select i from PostLikes i where i.personId.id=:id")
                .setParameter("id",id).list();
        List<PostLikesDto>  postLikesDtos=new ArrayList<>(postLikes.size());
        for(PostLikes postLikes1:postLikes){
            postLikesDtos.add(convert(postLikes1));
        }
        return postLikesDtos;
    }

    @Override
    public List<PostLikesDto> findAllPost(Long id) {
        List<PostLikes> postLikes=sessionFactory.getCurrentSession()
                .createQuery("select i from PostLikes i where i.postId.id=:id")
                .setParameter("id",id).list();
        List<PostLikesDto>  postLikesDtos=new ArrayList<>(postLikes.size());
        for(PostLikes postLikes1:postLikes){
            postLikesDtos.add(convert(postLikes1));
        }
        return postLikesDtos;
    }

    @Override
    public List<PostLikesDto> findAllPostPerson(Long idPerson, Long idPost) {
        List<PostLikes> postLikes=sessionFactory.getCurrentSession()
                .createQuery("select i from PostLikes i where i.postId.id=:idPost and i.personId.id=:idPerson")
                .setParameter("idPerson",idPerson).setParameter("idPost",idPost).list();
        List<PostLikesDto>  postLikesDtos=new ArrayList<>(postLikes.size());
        for(PostLikes postLikes1:postLikes){
            postLikesDtos.add(convert(postLikes1));
        }
        return postLikesDtos;
    }

    @Override
    @Transactional(readOnly = false)
    public long create(PostLikesDto postLikesDto) {
        PostLikes postLikes=convert(postLikesDto);
        sessionFactory.getCurrentSession().save(postLikes);
        return postLikes.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(PostLikesDto postLikesDto) {
        PostLikes postLikes=convert(postLikesDto);
        sessionFactory.getCurrentSession().save(postLikes);

    }
}
