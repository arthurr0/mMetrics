package pl.minecodes.mmetrics.metric;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.minecodes.mmetrics.metric.rest.MetricPushRequest;
import pl.minecodes.mmetrics.metric.rest.MetricResponse;
import pl.minecodes.mmetrics.metric.rest.MetricValuesResponse;
import pl.minecodes.mmetrics.product.Product;
import pl.minecodes.mmetrics.product.ProductService;

@RestController
@RequestMapping("/api/v1/metric")
public class MetricController {

  private final MetricFactory metricFactory;
  private final MetricService metricService;
  private final ProductService productService;

  public MetricController(
      MetricFactory metricFactory,
      MetricService metricService,
      ProductService productService
  ) {
    this.metricFactory = metricFactory;
    this.metricService = metricService;
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<?> pushMetric(@RequestBody MetricPushRequest request) {
    Optional<Product> optionalProduct = this.productService.findByApiCode(request.getApiCode());
    if (optionalProduct.isEmpty()) {
      throw new MetricNotFoundException("Product with api code " + request.getApiCode() + " not found");
    }

    Metric metric = this.metricFactory.createMetric(
        request.getName(),
        request.getValue(),
        optionalProduct.get()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(new MetricResponse(this.metricService.save(metric)));
  }

  @GetMapping
  public ResponseEntity<?> getMetrics(@RequestParam Integer apiCode, @RequestParam String name) {
    Optional<Product> optionalProduct = this.productService.findByApiCode(apiCode);
    if (optionalProduct.isEmpty()) {
      throw new MetricNotFoundException("Product with api code " + apiCode + " not found");
    }

    return ResponseEntity.ok(new MetricValuesResponse(name, this.metricService.countValuesByProductIdAndName(optionalProduct.get().getId(), name)));
  }
}
