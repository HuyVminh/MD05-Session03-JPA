package ra.huyga.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.huyga.model.entity.Product;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
