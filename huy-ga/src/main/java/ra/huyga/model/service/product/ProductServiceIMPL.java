package ra.huyga.model.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.huyga.model.entity.Category;
import ra.huyga.model.entity.Product;
import ra.huyga.model.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIMPL implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
