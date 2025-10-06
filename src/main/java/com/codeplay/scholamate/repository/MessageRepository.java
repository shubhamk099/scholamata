package com.codeplay.scholamate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeplay.scholamate.domain.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
    
}
