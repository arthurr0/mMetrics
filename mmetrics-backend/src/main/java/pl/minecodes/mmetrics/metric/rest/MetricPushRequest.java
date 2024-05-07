package pl.minecodes.mmetrics.metric.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricPushRequest {

  @NonNull
  private Integer apiCode;
  @NonNull
  private String name;
  @NonNull
  private String value;

}
