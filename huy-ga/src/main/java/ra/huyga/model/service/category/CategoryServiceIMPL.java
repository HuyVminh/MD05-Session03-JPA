package ra.huyga.model.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.huyga.model.entity.Category;
import ra.huyga.model.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceIMPL implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
