package edu.klaus.product.business.bci;

import edu.klaus.product.business.model.CategoryDTO;

import java.util.List;

public interface CategoryBCI {
    List<CategoryDTO> findAll();

    CategoryDTO getById(Long id);

    CategoryDTO create(CategoryDTO categoryDTO);

    Boolean delete(Long id);
}
