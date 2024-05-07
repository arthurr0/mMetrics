package pl.minecodes.mmetrics.product;

import java.time.Instant;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.minecodes.mmetrics.product.rest.ProductCreateRequest;
import pl.minecodes.mmetrics.product.rest.ProductResponse;
import pl.minecodes.mmetrics.product.rest.ProductUpdateRequest;
import pl.minecodes.mmetrics.user.User;
import pl.minecodes.mmetrics.user.UserService;

@RestController
@RequestMapping("/api/v1/product")
class ProductController {

  private final UserService userService;
  private final ProductFactory productFactory;
  private final ProductService productService;

  public ProductController(UserService userService, ProductFactory productFactory, ProductService productService) {
    this.userService = userService;
    this.productFactory = productFactory;
    this.productService = productService;
  }

  @PutMapping
  public ResponseEntity<?> createMetric(@RequestBody ProductCreateRequest request) {
    if (request.getName() == null || request.getDescription() == null || request.getType() == null) {
      throw new ProductCreationException("Name,description and type cannot be null.");
    }

    if (request.getName().length() < 3 || request.getName().length() > 64) {
      throw new ProductCreationException("Name must be between 3 and 64 characters.");
    }

    if (request.getDescription().length() < 3 || request.getDescription().length() > 256) {
      throw new ProductCreationException("Description must be between 3 and 256 characters.");
    }

    Optional<User> userSession = this.userService.findUserSession();
    if (userSession.isEmpty()) {
      throw new ProductCreationException("Session user not found.");
    }

    Product metric = this.productFactory.createMetric(request, userSession.get());

    return ResponseEntity.status(HttpStatus.CREATED).body(new ProductResponse(this.productService.save(metric)));
  }

  @PostMapping
  public ResponseEntity<?> updateMetric(@RequestBody ProductUpdateRequest request) {
    if (request.getId() == null) {
      throw new ProductUpdateException("Metric id cannot be null.");
    }

    Product dbMetric = this.productService.findById(request.getId())
        .orElseThrow(() -> new ProductNotFoundException("Metric not found."));

    if (request.getName() != null) {
      dbMetric.setName(request.getName());
    }

    if (request.getDescription() != null) {
      dbMetric.setDescription(request.getDescription());
    }

    dbMetric.setUpdatedAt(Instant.now());

    this.productService.save(dbMetric);

    return ResponseEntity.status(HttpStatus.OK).body(new ProductResponse(dbMetric));
  }

}
