package org.example.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Message;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponseMessage extends ResponseMessage {

  @JsonProperty("topic")
  private List<Message> messageList;

  public MessageResponseMessage(
      String status, String message, int code, List<Message> messageList) {
    super(status, message, code);
    this.messageList = messageList;
  }
}
