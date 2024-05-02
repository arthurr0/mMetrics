package pl.minecodes.mmetrics.user;

import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Find user by sequence generated id.
   * @param id User id.
   * @return Optional for user object.
   */
  public Optional<User> findById(Long id) {
    return this.userRepository.findById(id);
  }

  /**
   * Find user by username.
   * @param username User username.
   * @return Optional for user object.
   */
  public Optional<User> findByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  public Optional<User> findByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  /**
   * Find user from session context.
   * @return Optional for user object.
   */
  public Optional<User> findUserSession() {
    return this.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }

  /**
   * Save user to database.
   * @param user User object.
   * @return User object.
   */
  public User save(User user) {
    return this.userRepository.save(user);
  }
}
