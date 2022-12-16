package stadnik.evastore.controller;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stadnik.evastore.dto.mapper.ProductMapper;
import stadnik.evastore.dto.request.ProductRequestDto;
import stadnik.evastore.dto.response.ProductResponseDto;
import stadnik.evastore.model.Product;
import stadnik.evastore.service.ProductService;

@RestController
@RequestMapping("/shop")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    //----Mock DB for check----
    @GetMapping("/inject")
    public void saveProducts() {
        Product cream = new Product();
        cream.setName("cream");
        cream.setDescription("creeeeeeaaaaam");
        productService.save(cream);

        Product cream2 = new Product();
        cream2.setName("cream");
        cream2.setDescription("crrrrrrreammmmm");
        productService.save(cream2);

        Product soap = new Product();
        soap.setName("soap");
        soap.setDescription("soooooaaaap");
        productService.save(soap);

        Product soap2 = new Product();
        soap2.setName("soap");
        soap2.setDescription("sssssssappppppp");
        productService.save(soap2);

        Product perfume = new Product();
        perfume.setName("perfume");
        perfume.setDescription("peeeerfuuuuumeeee");
        productService.save(perfume);

        Product perfume2 = new Product();
        perfume2.setName("perfume");
        perfume2.setDescription("ppppprrrrffffummme");
        productService.save(perfume2);
    }

    @PostMapping
    @ApiOperation(value = "Create a new product")
    public ProductResponseDto create(@RequestBody ProductRequestDto requestDto) {
        Product product = productService.save(productMapper.toModel(requestDto));
        return productMapper.toResponseDto(product);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Create a product by id")
    public ProductResponseDto get(@PathVariable Long id) {
        return productMapper.toResponseDto(productService.findById(id));
    }

    @GetMapping()
    @ApiOperation(value = "Get products list")
    public List<ProductResponseDto> findAll(@RequestParam(defaultValue = "20")
                                            @ApiParam(value = "default value is '20'")
                                                    Integer count,
                                            @RequestParam(defaultValue = "0")
                                            @ApiParam(value = "default value is '0'")
                                                    Integer page,
                                            @RequestParam(defaultValue = "id") String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return productService.findAll(pageRequest).stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/product")
    @ApiOperation(value = "Get products list except products containing 'letters'")
    public List<ProductResponseDto> findAllByTitleIsNotLike(@RequestParam String nameFilter) {
        if (nameFilter.length() == 1) {
            return productService.findAllByFirstTitleIsNotLike(nameFilter).stream()
                    .map(productMapper::toResponseDto)
                    .collect(Collectors.toList());
        }
        return productService.findAllByBetweenTitleIsNotLike(nameFilter).stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a product by id")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a product")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = productMapper.toModel(requestDto);
        product.setId(id);
        return productMapper.toResponseDto(productService.update(product));
    }
}
