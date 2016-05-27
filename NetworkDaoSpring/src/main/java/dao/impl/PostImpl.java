package dao.impl;

import dao.PostDao;
import dao.entities.Post;
import dao.model.PostDto;
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
@Transactional(readOnly = true)
public class PostImpl  implements PostDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<PostDto> findAll() {
        List<Post> posts=sessionFactory.getCurrentSession().createQuery("from Post").list();
        List<PostDto> postDtos= new ArrayList<>(posts.size());
        for (Post post:posts){
            postDtos.add(convert(post));
        }
        return postDtos;
    }

    @Override
    public PostDto findById(long id) {
        Post post=(Post)sessionFactory.getCurrentSession().createQuery("select i from Post i where i.id=:id")
                .setParameter("id",id).uniqueResult();

        return post==null?null:convert(post);
    }

    @Override
    public PostDto findByTitle(String title) {
        Post post=(Post)sessionFactory.getCurrentSession().createQuery("select i from Post i where i.title=:title")
                .setParameter("title",title).uniqueResult();

        return post==null?null:convert(post);
    }

    @Override
    @Transactional(readOnly = false)
    public long create(PostDto postDto) {
        Post post=convert(postDto);
        sessionFactory.getCurrentSession().save(post);
        return post.getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(PostDto postDto) {
        Post post=convert(postDto);
        sessionFactory.getCurrentSession().saveOrUpdate(post);

    }

    @Override
    public List<PostDto> findPostByPerson(long id) {
        List<Post> posts=sessionFactory.getCurrentSession().createQuery("select i from Post i where i.person.id=:id")
                .setParameter("id",id).list();
        List<PostDto> postDtos= new ArrayList<>(posts.size());
        for (Post post:posts){
            postDtos.add(convert(post));
        }
        return postDtos;
    }
}
