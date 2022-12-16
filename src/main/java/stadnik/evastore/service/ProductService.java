package stadnik.evastore.service;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import stadnik.evastore.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    List<Product> findAll(PageRequest pageRequest);

    List<Product> findAllByFirstTitleIsNotLike(String letter);

    List<Product> findAllByBetweenTitleIsNotLike(String letters);

    Product findById(Long id);

    Product update(Product product);

    void delete(Long id);
}
