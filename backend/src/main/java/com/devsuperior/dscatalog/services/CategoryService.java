package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.exception.BusinessException;
import com.devsuperior.dscatalog.mappers.CategoryMapper;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        var result = repository.findAll();

        return mapper.toCategoryDTOs(result);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findBydId(Long id) {
        var result = repository.findById(id);

        var category =  result.orElseThrow(() -> new BusinessException("Entity not found", HttpStatus.NOT_FOUND.value()));

        return mapper.toCategoryDTO(category);
    }
}
