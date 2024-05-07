package pl.minecodes.mmetrics.metric.rest;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricValuesResponse {

  private String name;

  private Map<String, Long> values;

}
