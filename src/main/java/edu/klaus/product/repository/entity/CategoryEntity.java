package edu.klaus.product.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<ProductEntity> productEntityList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductEntity> getProductList() {
        return productEntityList;
    }

    public void setProductList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

}
