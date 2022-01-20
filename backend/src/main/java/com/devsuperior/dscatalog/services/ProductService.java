package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.exception.BusinessException;
import com.devsuperior.dscatalog.mappers.ProductMapper;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
        var result = repository.findAll(pageRequest);
        return result.map(mapper::toProductDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO findBydId(Long id) {
        var result = repository.findById(id);
        var Product =  result.orElseThrow(() -> new BusinessException("Entity not found", HttpStatus.NOT_FOUND.value()));
        return mapper.toProductDTO(Product);
    }

    @Transactional
    public ProductDTO create(ProductDTO ProductDTO) {
        var result = repository.save(mapper.toProduct(ProductDTO));
        return mapper.toProductDTO(result);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO ProductDTO) {
        try {
            var Product = repository.getOne(id);
//            Product.setName(ProductDTO.getName());
            var result = repository.save(Product);
            return mapper.toProductDTO(result);

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
