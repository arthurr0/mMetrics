package pl.minecodes.mmetrics.metric.minecraft;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MinecraftMetricRepository extends JpaRepository<MinecraftMetric, Long> {

}
