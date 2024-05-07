package pl.minecodes.mmetrics.product;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByApiCode(int apiCode);

}
