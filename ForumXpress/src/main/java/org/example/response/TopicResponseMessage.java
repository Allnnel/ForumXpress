package org.example.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Topic;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicResponseMessage extends ResponseMessage {

  @JsonProperty("topic")
  private List<Topic> topicList;

  public TopicResponseMessage(String status, String message, int code, List<Topic> topicList) {
    super(status, message, code);
    this.topicList = topicList;
  }
}
