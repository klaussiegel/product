package edu.klaus.product.business.bci;

import edu.klaus.product.business.model.ProductDTO;

import java.util.List;

public interface ProductBCI {
    List<ProductDTO> findAll();

    ProductDTO getById(Long id);
}
