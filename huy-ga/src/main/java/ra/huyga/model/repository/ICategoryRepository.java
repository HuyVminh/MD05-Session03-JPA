package ra.huyga.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.huyga.model.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
