package dao;

import dao.model.PostLikesDto;

import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface PostLikesDao {
    List<PostLikesDto> findAll();


    List<PostLikesDto> findAllPerson(Long id);
    List<PostLikesDto> findAllPost(Long id);
    List<PostLikesDto> findAllPostPerson(Long idPerson,Long idPost);

    long create(PostLikesDto postLikesDto);
    long update(PostLikesDto postLikesDto);
    void remove(PostLikesDto postLikesDto);
}
