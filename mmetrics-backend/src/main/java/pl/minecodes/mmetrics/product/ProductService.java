package pl.minecodes.mmetrics.product;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Optional<Product> findById(Long id) {
    return this.productRepository.findById(id);
  }

  public Product save(Product metric) {
    return this.productRepository.save(metric);
  }
}
