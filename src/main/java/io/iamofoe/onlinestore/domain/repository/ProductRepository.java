package io.iamofoe.onlinestore.domain.repository;

import io.iamofoe.onlinestore.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
