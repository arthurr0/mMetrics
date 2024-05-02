package pl.minecodes.mmetrics.metric.minecraft;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.minecodes.mmetrics.metric.minecraft.rest.MinecraftMetricCreateRequest;
import pl.minecodes.mmetrics.product.Product;
import pl.minecodes.mmetrics.product.ProductService;
import pl.minecodes.mmetrics.util.AddressUtil;
import pl.minecodes.mmetrics.util.GeoLocationUtil;

@RestController
@RequestMapping("/api/v1/metrics/minecraft")
class MinecraftMetricController {

  private final ProductService productService;
  private final MinecraftMetricFactory minecraftMetricFactory;
  private final MinecraftMetricService minecraftMetricService;

  public MinecraftMetricController(
      ProductService productService,
      MinecraftMetricFactory minecraftMetricFactory,
      MinecraftMetricService minecraftMetricService
  ) {
    this.productService = productService;
    this.minecraftMetricFactory = minecraftMetricFactory;
    this.minecraftMetricService = minecraftMetricService;
  }

  @PutMapping
  public ResponseEntity<?> createMetric(@RequestBody MinecraftMetricCreateRequest request, HttpServletRequest httpRequest) {
    Optional<Product> productOptional = this.productService.findByApiCode(request.getApiCode());
    if (productOptional.isEmpty()) {
      throw new MinecraftMetricProductNotFoundException("Product with api code " + request.getApiCode() + " not found");
    }

    Product product = productOptional.get();
    String requestAddress = AddressUtil.getRealRequestAddress(httpRequest);
    String country = GeoLocationUtil.getCountry(requestAddress);

    MinecraftMetric metric = this.minecraftMetricFactory.createMetric(
        request,
        country,
        product
    );

    this.minecraftMetricService.save(metric);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
