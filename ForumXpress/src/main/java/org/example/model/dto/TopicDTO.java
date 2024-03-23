package org.example.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {
  private String title;
  private List<MessageDTO> messages;

  public TopicDTO() {}
}
