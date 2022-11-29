package edu.klaus.product.business.bc;

import edu.klaus.product.business.bci.CategoryBCI;
import edu.klaus.product.business.mapping.CategoryMapper;
import edu.klaus.product.business.model.CategoryDTO;
import edu.klaus.product.repository.CategoryRepository;
import edu.klaus.product.repository.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("categoryBC")
public class CategoryBC implements CategoryBCI {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(Long id) {
        return categoryMapper.mapToDTO(categoryRepository.getById(id));
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryMapper.mapToEntity(categoryDTO));
        return categoryMapper.mapToDTO(categoryEntity);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            CategoryEntity categoryEntity = categoryRepository.getById(id);
            categoryRepository.delete(categoryEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
