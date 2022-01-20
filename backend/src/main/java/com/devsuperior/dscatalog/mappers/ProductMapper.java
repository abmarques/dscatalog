package com.devsuperior.dscatalog.mappers;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface ProductMapper {

    ProductDTO  toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
