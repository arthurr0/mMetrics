package pl.minecodes.mmetrics.metric;

import org.springframework.stereotype.Component;
import pl.minecodes.mmetrics.product.Product;

@Component
class MetricFactory {

  public Metric createMetric(String name, String value, Product product) {
    return new Metric(product, name, value);
  }

}
