package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.exception.BusinessException;
import com.devsuperior.dscatalog.mappers.CategoryMapper;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(Pageable pageable) {
        var result = repository.findAll(pageable);
        return result.map(mapper::toCategoryDTO);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findBydId(Long id) {
        var result = repository.findById(id);
        var category =  result.orElseThrow(() -> new BusinessException("Entity not found", HttpStatus.NOT_FOUND.value()));
        return mapper.toCategoryDTO(category);
    }

    @Transactional
    public CategoryDTO create(CategoryDTO categoryDTO) {
        var result = repository.save(mapper.toCategory(categoryDTO));
        return mapper.toCategoryDTO(result);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        try {
            var category = repository.getOne(id);
            category.setName(categoryDTO.getName());
            category.setUpdatedAt(Instant.now());
            var result = repository.save(category);
            return mapper.toCategoryDTO(result);

        } catch (EntityNotFoundException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            throw new BusinessException("An error occurred: " + e.getMessage());
        }
    }
}
