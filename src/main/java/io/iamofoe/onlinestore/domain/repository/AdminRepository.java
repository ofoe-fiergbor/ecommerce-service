package io.iamofoe.onlinestore.domain.repository;

import io.iamofoe.onlinestore.domain.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    boolean existsByEmail(String email);
    void deleteAdminByEmail(String email);
}
