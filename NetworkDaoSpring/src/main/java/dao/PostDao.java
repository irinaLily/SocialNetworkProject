package dao;

import dao.model.PostDto;
import dao.model.PostLikesDto;

import java.util.List;
import java.util.Set;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface PostDao {
    List<PostDto> findAll();
    PostDto findById(long id);
    PostDto findByTitle(String title);
    long create(PostDto postDto);
    void update(PostDto postDto);
    List<PostDto> findPostByPerson(long id);
}
