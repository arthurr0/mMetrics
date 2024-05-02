package pl.minecodes.mmetrics.metric.minecraft;

import java.time.Instant;
import org.springframework.stereotype.Component;
import pl.minecodes.mmetrics.metric.minecraft.rest.MinecraftMetricCreateRequest;
import pl.minecodes.mmetrics.product.Product;

@Component
class MinecraftMetricFactory {

  public MinecraftMetric createMetric(MinecraftMetricCreateRequest request, String country, Product product) {
    return new MinecraftMetric(
        product,
        Instant.now(),
        country,
        request.getProductVersion(),
        request.getPlayersOnline(),
        request.getSoftwareName(),
        request.getSoftwareVersion(),
        request.getSoftwareVersion()
    );
  }
}
