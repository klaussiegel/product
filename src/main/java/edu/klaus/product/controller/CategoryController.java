package edu.klaus.product.controller;

import edu.klaus.product.business.bc.CategoryBC;
import edu.klaus.product.business.model.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private CategoryBC categoryBC;

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryBC.findAll();
    }

    @GetMapping(value = "/{id}")
    public CategoryDTO getById(@PathVariable Long id){
        return categoryBC.getById(id);
    }
}
