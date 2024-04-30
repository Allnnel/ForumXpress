package org.example.controller;

import java.util.List;
import org.example.exception.CustomException;
import org.example.model.Security;
import org.example.response.ResponseMessage;
import org.example.response.SecurityResponseMessage;
import org.example.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {
  private final SecurityService service;

  @Autowired
  public SecurityController(SecurityService service) {
    this.service = service;
  }

  @GetMapping("security")
  public ResponseEntity<ResponseMessage> getSecurity() throws CustomException {
    List<Security> securityList = service.findAll();
    ResponseMessage response =
        new SecurityResponseMessage("Successes", null, 200, securityList, null);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("security")
  public ResponseEntity<ResponseMessage> postSecurity(
      @RequestParam String login, @RequestParam String role, @RequestParam String password)
      throws CustomException {
    service.save(new Security(role, login, password));
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("security")
  public ResponseEntity<ResponseMessage> putSecurity(
      @RequestParam String login, @RequestParam String role, @RequestParam String password)
      throws CustomException {
    service.update(new Security(role, login, password));
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @DeleteMapping("security")
  public ResponseEntity<ResponseMessage> deleteSecurity(@RequestParam String login)
      throws CustomException {
    service.delete(login);
    ResponseMessage response = new ResponseMessage("Successes", null, 200);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
