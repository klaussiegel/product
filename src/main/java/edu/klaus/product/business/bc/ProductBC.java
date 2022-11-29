package edu.klaus.product.business.bc;

import edu.klaus.product.business.bci.ProductBCI;
import edu.klaus.product.business.mapping.CategoryMapper;
import edu.klaus.product.business.mapping.ProductMapper;
import edu.klaus.product.business.model.ProductDTO;
import edu.klaus.product.repository.CategoryRepository;
import edu.klaus.product.repository.ProductRepository;
import edu.klaus.product.repository.entity.CategoryEntity;
import edu.klaus.product.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("productBC")
public class ProductBC implements ProductBCI {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return productMapper.mapToDTO(productRepository.getById(id));
    }

    @Override
    public Boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            ProductEntity productEntity = productRepository.getById(id);
            productRepository.delete(productEntity);
            return true;
        }
        return false;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        CategoryEntity categoryEntity = categoryRepository.getById(productDTO.getCategoryId());
        ProductEntity productEntity = productMapper.mapToEntity(productDTO);
        productEntity.setCategory(categoryEntity);

        return productMapper.mapToDTO(productRepository.save(productEntity));
    }

    @Override
    public List<ProductDTO> findAllbyProductName(String name) {
        return productRepository.findAllByProductName(name).stream().map(productMapper::mapToDTO).collect(Collectors.toList());
    }
}
