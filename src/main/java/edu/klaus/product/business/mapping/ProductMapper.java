package edu.klaus.product.business.mapping;

import edu.klaus.product.business.model.ProductDTO;
import edu.klaus.product.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productMapper")
public class ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    public ProductDTO mapToDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setStock(productEntity.getStock());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setCategoryDTO(categoryMapper.mapToDTO(productEntity.getCategory()));

        return productDTO;
    }

    public ProductEntity mapToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

//        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setStock(productDTO.getStock());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
//        productEntity.setCategory(categoryMapper.mapToEntity(productDTO.getCategoryDTO()));

        return productEntity;
    }
}
