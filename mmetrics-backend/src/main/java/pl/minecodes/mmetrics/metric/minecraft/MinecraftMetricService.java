package pl.minecodes.mmetrics.metric.minecraft;

import org.springframework.stereotype.Service;

@Service
public class MinecraftMetricService {

  public final MinecraftMetricRepository minecraftMetricRepository;

  public MinecraftMetricService(MinecraftMetricRepository minecraftMetricRepository) {
    this.minecraftMetricRepository = minecraftMetricRepository;
  }

  public void save(MinecraftMetric metric) {
    this.minecraftMetricRepository.save(metric);
  }
}
