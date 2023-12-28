package ra.huyga.model.entity;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @Column(columnDefinition = "boolean default true")
    private Boolean status;
@OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private Set<Product> products;
    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
