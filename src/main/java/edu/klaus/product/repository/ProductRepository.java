package edu.klaus.product.repository;

import edu.klaus.product.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("from ProductEntity pe where pe.name = ?1")
    List<ProductEntity> findAllByProductName(String name);
}
