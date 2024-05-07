package pl.minecodes.mmetrics.metric.rest;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.minecodes.mmetrics.metric.Metric;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricResponse {

  private Long id;
  private String name;
  private String value;
  private Long productId;
  private Instant createdAt;

  public MetricResponse(Metric metric) {
    this.id = metric.getId();
    this.name = metric.getName();
    this.value = metric.getValue();
    this.productId = metric.getProduct().getId();
    this.createdAt = metric.getCreatedAt();
  }

}
