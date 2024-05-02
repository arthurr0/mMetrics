package pl.minecodes.mmetrics.user.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

  private String username;
  private String password;
  private String email;

}
