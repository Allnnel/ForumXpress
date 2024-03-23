package org.example.repository;

import javax.transaction.Transactional;
import org.example.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TopicRepository extends JpaRepository<Topic, Long> {}
