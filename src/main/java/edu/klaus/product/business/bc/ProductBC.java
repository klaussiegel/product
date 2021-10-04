package edu.klaus.product.business.bc;

import edu.klaus.product.business.bci.ProductBCI;
import edu.klaus.product.business.mapping.ProductMapper;
import edu.klaus.product.business.model.ProductDTO;
import edu.klaus.product.repository.ProductRepository;
import edu.klaus.product.repository.impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("productBC")
public class ProductBC implements ProductBCI {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

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
}
