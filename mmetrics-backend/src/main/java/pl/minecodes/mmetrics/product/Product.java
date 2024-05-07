package pl.minecodes.mmetrics.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.minecodes.mmetrics.user.User;
import pl.minecodes.mmetrics.util.RandomNumberUtil;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(unique = true, nullable = false, updatable = false, length = 8)
  private int apiCode;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(unique = true, nullable = false, length = 64)
  private String name;

  @Column(nullable = false, length = 256)
  private String description;

  @Column(nullable = false)
  private ProductType type;

  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  private Instant updatedAt;

  public Product(String name, String description, ProductType type, User user) {
    this.apiCode = RandomNumberUtil.generateRandomNumber(10000000, 99999999);
    this.user = user;
    this.name = name;
    this.description = description;
    this.type = type;
    this.createdAt = Instant.now();
  }

}
