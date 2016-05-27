package dao;

import dao.model.FriendshipDto;

import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface FriendshipDao  {
    List<FriendshipDto> findAll();
    List<FriendshipDto>  findAllPerson(Long id);
    List<FriendshipDto>  findAllFriend(Long id);
    FriendshipDto  findPersonFriend(long idPerson,long idFriend);
    long create(FriendshipDto friendshipDto);
    void update(FriendshipDto friendshipDto);
}
