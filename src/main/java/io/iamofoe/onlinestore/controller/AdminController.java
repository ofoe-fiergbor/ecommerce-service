package io.iamofoe.onlinestore.controller;

import io.iamofoe.onlinestore.dto.request.AdminRequest;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;
import io.iamofoe.onlinestore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class AdminController {

    private final AdminService adminService;

    @Secured("ROLE_MASTER_ADMIN")
    @PostMapping
    ResponseEntity<AddAdminDto> addNewAdmin(AdminRequest request) {
        return new ResponseEntity<>(adminService.addAdmin(request), HttpStatus.CREATED);
    }

    @Secured("ROLE_MASTER_ADMIN")
    @DeleteMapping
    public ResponseEntity<?> removeAdmin(AdminRequest request) {
        adminService.removeAdmin(request);
        return ResponseEntity.noContent().build();
    }
    @Secured("ROLE_MASTER_ADMIN")
    @GetMapping
    public ResponseEntity<AllAdminDto> getAllAdmins() {
        return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
    }


}
