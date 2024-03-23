package org.example.repository;

import java.util.List;
import java.util.Optional;
import org.example.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SecurityRepository extends JpaRepository<Security, Long> {

  Optional<Security> findByLogin(String login);

  List<Security> findAll();

  void deleteByLogin(String login);
}
