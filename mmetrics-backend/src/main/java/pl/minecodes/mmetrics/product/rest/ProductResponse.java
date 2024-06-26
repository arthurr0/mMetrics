package pl.minecodes.mmetrics.product.rest;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.minecodes.mmetrics.product.Product;
import pl.minecodes.mmetrics.product.ProductType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

  private Long id;
  private int apiCode;
  private String name;
  private String description;
  private ProductType type;
  private Instant createdAt;
  private Instant updatedAt;

  public ProductResponse(Product metric) {
    this.id = metric.getId();
    this.apiCode = metric.getApiCode();
    this.name = metric.getName();
    this.description = metric.getDescription();
    this.type = metric.getType();
    this.createdAt = metric.getCreatedAt();
    this.updatedAt = metric.getUpdatedAt();
  }
}
