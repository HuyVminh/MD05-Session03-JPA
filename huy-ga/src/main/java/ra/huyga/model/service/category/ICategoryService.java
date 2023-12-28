package ra.huyga.model.service.category;

import ra.huyga.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category saveOrUpdate(Category category);

    Category findById(Long id);

    void delete(Long id);
}
