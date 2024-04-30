package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.example.exception.CustomException;
import org.example.model.Message;
import org.example.model.Topic;
import org.example.model.dto.*;
import org.example.response.MessageResponseMessage;
import org.example.response.ResponseMessage;
import org.example.response.TopicResponseMessage;
import org.example.service.MessageService;
import org.example.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForumController {

  private final MessageService messageService;
  private final TopicService topicService;

  @Autowired
  public ForumController(MessageService messageService, TopicService topicService) {
    this.messageService = messageService;
    this.topicService = topicService;
  }

  @GetMapping("topic")
  public ResponseEntity<ResponseMessage> getTopic() throws CustomException {
    List<Topic> topicList = topicService.findAll();
    ResponseMessage response = new TopicResponseMessage("Successes", null, 200, topicList);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("topic/{id}")
  public ResponseEntity<ResponseMessage> getIdTopic(@PathVariable Long id) throws CustomException {
    List<Message> messageList = topicService.getMessagesInTopic(id);
    ResponseMessage response = new MessageResponseMessage("Successes", null, 200, messageList);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("topic")
  public ResponseEntity<ResponseMessage> postTopic(@RequestBody TopicDTO topicDTO)
      throws CustomException {
    Topic topic = new Topic(topicDTO.getTitle(), new ArrayList<>());
    topicService.save(topic);
    if (!topicDTO.getMessages().isEmpty()) {
      MessageDTO messageDTO = topicDTO.getMessages().get(0);
      Message message =
          new Message(
              messageDTO.getAuthorName(), messageDTO.getText(), messageDTO.getCreationDate(), null);
      topicService.addMessageToTopic(topic.getId(), message);
    }
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("topic/{id}")
  public ResponseEntity<ResponseMessage> postMessageTopic(
      @PathVariable Long id, @RequestBody Message message) throws CustomException {
    topicService.addMessageToTopic(id, message);
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("message/{id}")
  public ResponseEntity<ResponseMessage> putMessage(
      @PathVariable Long id, @RequestBody Message message) throws CustomException {
    messageService.updateMessage(id, message);
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @DeleteMapping("message/{id}")
  public ResponseEntity<ResponseMessage> deleteMessage(@PathVariable Long id)
      throws CustomException {
    messageService.delete(id);
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
