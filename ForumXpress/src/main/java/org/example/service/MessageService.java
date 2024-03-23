package org.example.service;

import org.example.exception.CustomException;
import org.example.model.Message;

public interface MessageService {
  void save(Message message);

  void updateMessage(Long messageId, Message updatedMessage) throws CustomException;

  void delete(Long messageId) throws CustomException;
}
