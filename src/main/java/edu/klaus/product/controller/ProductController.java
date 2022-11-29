package edu.klaus.product.controller;

import edu.klaus.product.business.bc.ProductBC;
import edu.klaus.product.business.model.ProductDTO;
import edu.klaus.product.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductBC productBC;

    @GetMapping(value = "/queryparamExamle")
    String queryParamExample(@RequestParam String id, @RequestParam String name) {
        return "id = " + id + ", name = " + name;
    }

    @GetMapping(value = "/getAllByName/{name}")
    public List<ProductDTO> getAllByName(@PathVariable("name") String name) {
        log.info("endpoint: getAllByName/" + name);
        return productBC.findAllbyProductName(name);
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        log.info("info in find all");
        return productBC.findAll();//claud development
    }

    @GetMapping(value = "/{id}")
    public ProductDTO get(@PathVariable Long id) {
        return productBC.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseMessage delete(@PathVariable Long id) {
        Boolean deleted = productBC.delete(id);
        ResponseMessage responseMessage = new ResponseMessage();
        if (deleted) {
            responseMessage.setMessage("The product has been successfully deleted!");
        } else {
            responseMessage.setMessage("The product was not deleted!");
        }
        return responseMessage;
    }

    @PostMapping(value = "/create")
    public ResponseMessage create(@RequestBody ProductDTO productDTO) {

        ProductDTO created = productBC.create(productDTO);

        ResponseMessage responseMessage = new ResponseMessage();

        if (created.getId().equals(null)) {
            responseMessage.setMessage("The product was NOT created!");
        } else {
            responseMessage.setMessage("The product was created successfully!");
        }

        return responseMessage;
    }


}