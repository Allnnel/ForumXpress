package org.example.model.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
  private String authorName;
  private String text;
  private Date creationDate;

  public MessageDTO() {}
}
