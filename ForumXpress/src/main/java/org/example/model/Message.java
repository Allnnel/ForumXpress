package org.example.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "message")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "author_name", nullable = false)
  private String authorName;

  @Column(name = "text", nullable = false)
  private String text;

  @Column(name = "creation_date", nullable = false)
  private Date creationDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "topic_id")
  private Topic topic;

  public Message() {}

  public Message(String authorName, String text, Date creationDate, Topic topic) {
    this.authorName = authorName;
    this.text = text;
    this.creationDate = creationDate;
    this.topic = topic;
  }
}
