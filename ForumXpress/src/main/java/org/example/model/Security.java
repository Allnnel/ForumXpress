package org.example.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@Table(name = "security")
public class Security {

  private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "role", nullable = false)
  private String role;

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "password", nullable = false)
  private String password;

  public Security() {}

  public Security(String role, String login, String password) {
    this.role = role;
    this.login = login;
    setPassword(password);
  }

  public void setPassword(String password) {
    this.password = passwordEncoder.encode(password);
  }

  public String encrypt(String rawPassword) {
    return passwordEncoder.encode(password);
  }
}
