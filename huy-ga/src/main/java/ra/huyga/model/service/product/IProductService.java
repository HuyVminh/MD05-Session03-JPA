package ra.huyga.model.service.product;

import ra.huyga.model.entity.Category;
import ra.huyga.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product saveOrUpdate(Product product);

    Product findById(Long id);

    void delete(Long id);
}
