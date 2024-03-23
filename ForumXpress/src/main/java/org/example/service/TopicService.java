package org.example.service;

import java.util.List;
import org.example.exception.CustomException;
import org.example.model.Message;
import org.example.model.Topic;

public interface TopicService {
  void save(Topic topic);

  List<Topic> findAll() throws CustomException;

  void addMessageToTopic(Long topicId, Message message) throws CustomException;

  List<Message> getMessagesInTopic(Long topicId) throws CustomException;
}
