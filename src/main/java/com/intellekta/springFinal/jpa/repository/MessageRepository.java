package com.intellekta.springFinal.jpa.repository;


import com.intellekta.springFinal.jpa.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

    List<MessageEntity> findByTag(String tag);
}
