package pl.minecodes.mmetrics.metric;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MetricRepository extends JpaRepository<Metric, Long> {

  List<Metric> findAllByProductId(long productId);

  List<Metric> findAllByNameAndProductId(String name, long productId);

  @Query("SELECT COUNT(m) FROM Metric m WHERE m.product.id = :productId AND m.name = :name")
  int countByProductAndName(Long productId, String name);

  @Query("SELECT m.value, COUNT(m.value) FROM Metric m WHERE m.product.id = :productId AND m.name = :name GROUP BY m.value")
  List<Object[]> countValuesByProductIdAndName(Long productId, String name);

}
