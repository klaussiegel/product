package edu.klaus.product.controller;

import edu.klaus.product.business.bc.ProductBC;
import edu.klaus.product.business.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductBC productBC;

    @GetMapping
    public List<ProductDTO> findAll() {
        log.info("info in find all");
        return productBC.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProductDTO get(@PathVariable Long id) {
        return productBC.getById(id);
    }

//    @PostMapping
//    public ProductEntity create(@RequestBody ProductEntity productEntity) {
//        return productRepository.save(productEntity);
//    }
//
//    @PutMapping(value = "{id}")
//    public void update(@PathVariable Long id, @RequestBody ProductEntity productEntity) {
//        productRepository.saveAndFlush(productEntity);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void delete(@PathVariable Long id) {
//        productRepository.deleteById(id);
//    }

}