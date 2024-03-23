package org.example.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Security;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityResponseMessage extends ResponseMessage {
  @JsonProperty("securities")
  private List<Security> securityList;

  @JsonProperty("security")
  private Security security;

  public SecurityResponseMessage(
      String status, String message, int code, List<Security> securityList, Security security) {
    super(status, message, code);
    this.security = security;
    this.securityList = securityList;
  }
}
