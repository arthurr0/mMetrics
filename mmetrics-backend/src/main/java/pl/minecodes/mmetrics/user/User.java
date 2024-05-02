package pl.minecodes.mmetrics.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false, length = 32)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(unique = true, nullable = false, length = 64)
  private String email;

  @Column(nullable = false)
  private UserRole role;

  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  private Instant updatedAt;

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = UserRole.USER;
    this.createdAt = Instant.now();
  }
}
