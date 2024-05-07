package pl.minecodes.mmetrics.metric;

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
import pl.minecodes.mmetrics.product.Product;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Metric {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String value;

  @Column(nullable = false)
  private Instant createdAt;

  public Metric(Product product, String name, String value) {
    this.product = product;
    this.name = name;
    this.value = value;
    this.createdAt = Instant.now();
  }
}
