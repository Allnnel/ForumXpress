package org.example.service.impl;

import java.util.Optional;
import org.example.exception.CustomException;
import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository messageRepository;

  @Autowired
  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public void save(Message message) {
    messageRepository.save(message);
  }

  @Override
  public void updateMessage(Long messageId, Message updatedMessage) throws CustomException {
    Optional<Message> optionalMessage = messageRepository.findById(messageId);
    if (optionalMessage.isPresent()) {
      Message message = optionalMessage.get();
      message.setText(updatedMessage.getText());
      messageRepository.save(message);
    } else {
      throw new CustomException("MESSAGE_NOT_FOUND", 404);
    }
  }

  @Override
  public void delete(Long messageId) throws CustomException {
    Optional<Message> optionalMessage = messageRepository.findById(messageId);
    if (optionalMessage.isPresent()) {
      Message message = optionalMessage.get();
      messageRepository.delete(message);
    } else {
      throw new CustomException("MESSAGE_NOT_FOUND", 404);
    }
  }
}
