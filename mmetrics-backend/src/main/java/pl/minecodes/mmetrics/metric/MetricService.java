package pl.minecodes.mmetrics.metric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.minecodes.mmetrics.product.Product;

@Service
public class MetricService {

  private final MetricRepository metricRepository;

  public MetricService(MetricRepository metricRepository) {
    this.metricRepository = metricRepository;
  }

  public Optional<Metric> findById(Long id) {
    return this.metricRepository.findById(id);
  }

  public List<Metric> findAllByProductId(long productId) {
    return this.metricRepository.findAllByProductId(productId);
  }

  public List<Metric> findAllByNameAndProductId(String name, long productId) {
    return this.metricRepository.findAllByNameAndProductId(name, productId);
  }

  public Metric save(Metric metric) {
    return this.metricRepository.save(metric);
  }

  public int countByProductAndName(Product product, String name) {
    return this.metricRepository.countByProductAndName(product.getId(), name);
  }

  public Map<String, Long> countValuesByProductIdAndName(Long productId, String name) {
    List<Object[]> results = this.metricRepository.countValuesByProductIdAndName(productId, name);
    Map<String, Long> resultMap = new HashMap<>();
    for (Object[] result : results) {
      resultMap.put((String) result[0], (Long) result[1]);
    }
    return resultMap;
  }
}
