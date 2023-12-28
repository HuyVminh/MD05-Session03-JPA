package ra.huyga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.huyga.model.entity.Category;
import ra.huyga.model.entity.Product;
import ra.huyga.model.service.category.ICategoryService;
import ra.huyga.model.service.product.IProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String category(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("list", productList);
        return "/product/index";
    }

    @GetMapping({"/add-product", "/edit-product/{id}"})
    public String saveProduct(@PathVariable(value = "id", required = false) Long id, Model model) {
        Product product;
        if (id == null) {
            product = new Product();
        } else {
            product = productService.findById(id);
        }
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", product);
        return "/product/add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
