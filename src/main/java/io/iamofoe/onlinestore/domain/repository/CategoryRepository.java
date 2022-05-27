package io.iamofoe.onlinestore.domain.repository;

import io.iamofoe.onlinestore.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
