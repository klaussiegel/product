package edu.klaus.product.controller;

import edu.klaus.product.business.bc.CategoryBC;
import edu.klaus.product.business.model.CategoryDTO;
import edu.klaus.product.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CategoryDTO getById(@PathVariable Long id) {
        return categoryBC.getById(id);
    }

    @PostMapping(value = "/create")
    public ResponseMessage create(@RequestBody CategoryDTO categoryDTO) {

        CategoryDTO created = categoryBC.create(categoryDTO);
        ResponseMessage responseMessage = new ResponseMessage();

        if (created.getId().equals(null)) {
            responseMessage.setMessage("Category was NOT created!");
        } else {
            responseMessage.setMessage("Category was created successfully!");
        }

        return responseMessage;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseMessage delete(@PathVariable Long id) {
        Boolean deleted = categoryBC.delete(id);
        ResponseMessage responseMessage = new ResponseMessage();
        if (deleted) {
            responseMessage.setMessage("Category was deleted!");
        } else {
            responseMessage.setMessage("Category can not be deleted!");
        }
        return responseMessage;
    }
}
