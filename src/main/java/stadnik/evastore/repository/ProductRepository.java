package stadnik.evastore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stadnik.evastore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Product p "
            + "WHERE upper(p.name) NOT LIKE concat(upper(?1), '%')", nativeQuery = true)
    List<Product> findAllByFirstTitleIsNotLike(String letter);

    @Query(value = "SELECT * FROM Product p "
            + "WHERE upper(p.name) NOT LIKE concat('%', upper(?1), '%')", nativeQuery = true)
    List<Product> findAllByBetweenTitleIsNotLike(String letters);
}
