package org.example.service.impl;

import java.util.List;
import java.util.Optional;
import org.example.exception.CustomException;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.repository.TopicRepository;
import org.example.service.MessageService;
import org.example.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

  private final TopicRepository topicRepository;
  private final MessageService messageService;

  @Autowired
  public TopicServiceImpl(TopicRepository topicRepository, MessageService messageService) {
    this.topicRepository = topicRepository;
    this.messageService = messageService;
  }

  @Override
  public void save(Topic topic) {
    topicRepository.save(topic);
  }

  @Override
  public List<Topic> findAll() throws CustomException {
    List<Topic> topicList = topicRepository.findAll();
    if (topicList.isEmpty()) {
      throw new CustomException("TOPIC_NOT_FOUND", 500);
    }
    return topicList;
  }

  @Override
  public void addMessageToTopic(Long topicId, Message message) throws CustomException {
    Optional<Topic> optionalTopic = topicRepository.findById(topicId);
    if (optionalTopic.isPresent()) {
      Topic topic = optionalTopic.get();
      message.setTopic(topic);
      messageService.save(message);
      topic.getMessages().add(message);
    } else {
      throw new CustomException("TOPIC_NOT_FOUND", 500);
    }
  }

  @Override
  public List<Message> getMessagesInTopic(Long topicId) throws CustomException {
    Optional<Topic> optionalTopic = topicRepository.findById(topicId);
    if (optionalTopic.isPresent()) {
      Topic topic = optionalTopic.get();
      return topic.getMessages();
    } else {
      throw new CustomException("TOPIC_NOT_FOUND", 500);
    }
  }
}
