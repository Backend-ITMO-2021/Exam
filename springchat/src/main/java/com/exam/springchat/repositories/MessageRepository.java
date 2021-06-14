package com.exam.springchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository.*;
import org.springframework.stereotype.Repository;
import com.exam.springchat.entities.MessageEntity;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Integer> {
}
