package ra.huyga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.huyga.model.entity.Category;
import ra.huyga.model.service.category.ICategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public String category(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("list", categoryList);
        return "/category/index";
    }

    @GetMapping({"/add-category", "/edit-category/{id}"})
    public String saveCategory(@PathVariable(value = "id", required = false) Long id, Model model) {
        Category category;
        if(id == null){
            category = new Category();
        }else {
            category = categoryService.findById(id);
        }
        model.addAttribute("category", category);
        return "/category/add-category";
    }
    @PostMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category category){
        categoryService.saveOrUpdate(category);
        return "redirect:/category";
    }
    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
