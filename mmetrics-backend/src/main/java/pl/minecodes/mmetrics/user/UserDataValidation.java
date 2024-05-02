package pl.minecodes.mmetrics.user;

import org.springframework.stereotype.Component;

@Component
class UserDataValidation {

  public boolean emailValid(String email) {
    return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
  }

  public boolean passwordRestrictionsValid(String password) {
    return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
  }

}
