package stadnik.evastore.dto.mapper;

import org.springframework.stereotype.Component;
import stadnik.evastore.dto.request.ProductRequestDto;
import stadnik.evastore.dto.response.ProductResponseDto;
import stadnik.evastore.model.Product;

@Component
public class ProductMapper {
    public ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        return responseDto;
    }

    public Product toModel(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        return product;
    }
}
