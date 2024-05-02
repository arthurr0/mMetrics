package pl.minecodes.mmetrics.product;

import org.springframework.stereotype.Component;
import pl.minecodes.mmetrics.product.rest.ProductCreateRequest;
import pl.minecodes.mmetrics.user.User;

@Component
class ProductFactory {

  public Product createMetric(ProductCreateRequest request, User user) {
    return new Product(request.getName(), request.getDescription(), user);
  }

}
