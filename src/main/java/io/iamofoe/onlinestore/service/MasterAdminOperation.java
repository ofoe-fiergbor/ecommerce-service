package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.converter.AdminToAddAdminDto;
import io.iamofoe.onlinestore.converter.AdminsToAllAdminDto;
import io.iamofoe.onlinestore.domain.model.Admin;
import io.iamofoe.onlinestore.domain.repository.AdminRepository;
import io.iamofoe.onlinestore.dto.request.AdminRequest;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MasterAdminOperation implements AdminService{

    private final AdminRepository adminRepository;
    private final AdminToAddAdminDto toAddAdminDtoConverter;
    private final AdminsToAllAdminDto toAllAdminDtoConverter;

    @Override
    public AddAdminDto addAdmin(AdminRequest request) {
        Admin newAdmin = new Admin().setEmail(request.getEmail());
        return toAddAdminDtoConverter.convert(adminRepository.save(newAdmin));
    }

    @Override
    public void removeAdmin(AdminRequest request) {
        adminRepository.deleteAdminByEmail(request.getEmail());
    }

    @Override
    public AllAdminDto getAllAdmins() {
        return toAllAdminDtoConverter.convert(adminRepository.findAll());
    }

    @Override
    public boolean isAdmin(String email) {
        return adminRepository.existsByEmail(email);
    }
}
