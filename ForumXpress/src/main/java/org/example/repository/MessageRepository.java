package org.example.repository;

import javax.transaction.Transactional;
import org.example.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {}
