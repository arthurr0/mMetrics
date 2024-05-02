package pl.minecodes.mmetrics.metric.minecraft.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinecraftMetricCreateRequest {

  private int apiCode;
  private String productVersion;
  private int playersOnline;
  private String softwareName;
  private String softwareVersion;
  private String javaVersion;

}
