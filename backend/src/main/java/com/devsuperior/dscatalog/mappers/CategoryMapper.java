package com.devsuperior.dscatalog.mappers;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "jsr330")
public interface CategoryMapper {

    CategoryDTO toCategoryDTO(Category category);

    default List<CategoryDTO> toCategoryDTOs(List<Category> categories) {
        return categories
                .stream()
                .map(this::toCategoryDTO)
                .collect(Collectors.toList());
    }

    Category toCategory(CategoryDTO categoryDTO);
}
