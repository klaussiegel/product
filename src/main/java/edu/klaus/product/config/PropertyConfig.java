package edu.klaus.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"file:C:\\Users\\UBB-L16\\KLAUS\\product\\example.properties"})
public class PropertyConfig {

    @Value("${app.example.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
