package pl.minecodes.mmetrics.product.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.minecodes.mmetrics.product.ProductType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequest {

  private Long id;

  private String name;
  private String description;
  private ProductType type;

}
