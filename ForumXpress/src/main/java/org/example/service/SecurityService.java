package org.example.service;

import java.util.List;
import org.example.exception.CustomException;
import org.example.model.Security;

public interface SecurityService {
  public enum RoleEnum {
    ADMIN,
    VIEWER,
    EDITOR
  }

  void save(Security security) throws CustomException;

  void update(Security security) throws CustomException;

  List<Security> findAll() throws CustomException;

  void delete(String login) throws CustomException;

  Security findByLogin(String login) throws CustomException;

  void isValidRole(String role) throws CustomException;
}
