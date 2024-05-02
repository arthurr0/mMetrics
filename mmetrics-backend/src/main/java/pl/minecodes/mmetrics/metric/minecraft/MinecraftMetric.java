package pl.minecodes.mmetrics.metric.minecraft;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MinecraftMetric {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(nullable = false)
  private Instant createdAt;

  @Column(nullable = false)
  private String country;

  @Column(nullable = false)
  private String productVersion;

  @Column(nullable = false)
  private int playersOnline;

  @Column(nullable = false)
  private String softwareName;

  @Column(nullable = false)
  private String softwareVersion;

  @Column(nullable = false)
  private String javaVersion;

  public MinecraftMetric(
      Product product,
      Instant createdAt,
      String country,
      String productVersion,
      int playersOnline,
      String softwareName,
      String softwareVersion,
      String javaVersion
  ) {
    this.product = product;
    this.createdAt = createdAt;
    this.country = country;
    this.productVersion = productVersion;
    this.playersOnline = playersOnline;
    this.softwareName = softwareName;
    this.softwareVersion = softwareVersion;
    this.javaVersion = javaVersion;
  }
}
