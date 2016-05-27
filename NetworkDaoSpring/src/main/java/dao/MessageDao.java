package dao;

import dao.model.MessageDto;

import java.util.List;

/**
 * Created by Ирина on 22.04.2016.
 */
public interface MessageDao  {
    List<MessageDto> findAll();
    MessageDto findById(long id);
    MessageDto findByContent(String content);

    List<MessageDto> findAllPersonFrom(Long id);
    List<MessageDto> findAllPersonTo(Long id);

    long create(MessageDto messageDto);
    void update(MessageDto messageDto);
}
