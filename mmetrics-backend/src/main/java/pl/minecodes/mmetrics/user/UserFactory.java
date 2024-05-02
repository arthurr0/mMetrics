package pl.minecodes.mmetrics.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class UserFactory {

  private final PasswordEncoder passwordEncoder;

  public UserFactory(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public User createUser(String username, String password, String email) {
    return new User(username, this.passwordEncoder.encode(password), email);
  }

}
