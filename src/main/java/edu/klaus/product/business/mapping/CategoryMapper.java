package edu.klaus.product.business.mapping;

import edu.klaus.product.business.model.CategoryDTO;
import edu.klaus.product.repository.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component("categoryMapper")
public class CategoryMapper {
    public CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setDescription(categoryEntity.getDescription());

        return categoryDTO;
    }

    public CategoryEntity mapToEntity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(categoryDTO.getId());
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setDescription(categoryDTO.getDescription());

        return categoryEntity;
    }
}
