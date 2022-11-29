package edu.klaus.product.controller;

import edu.klaus.product.config.PropertyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/property")
@RestController
public class PropertyController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private PropertyConfig propertyConfig;

    @GetMapping
    public String getName() {
        log.info("get property name");
        return propertyConfig.getName();
    }
}
