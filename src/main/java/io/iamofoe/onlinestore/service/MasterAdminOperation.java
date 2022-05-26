package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.converter.AdminToAddAdminDto;
import io.iamofoe.onlinestore.converter.AdminsToAllAdminDto;
import io.iamofoe.onlinestore.domain.model.Admin;
import io.iamofoe.onlinestore.domain.repository.AdminRepository;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MasterAdminOperation implements AdminService{

    private final AdminRepository adminRepository;
    private final AdminToAddAdminDto toAddAdminDtoConverter;
    private final AdminsToAllAdminDto toAllAdminDtoConverter;

    @Override
    public AddAdminDto addAdmin(String email) {
        Admin newAdmin = new Admin().setEmail(email);
        return toAddAdminDtoConverter.convert(adminRepository.save(newAdmin));
    }

    @Override
    public void removeAdmin(String email) {
        adminRepository.deleteAdminByEmail(email);
    }

    @Override
    public AllAdminDto getAllAdmins() {
        return toAllAdminDtoConverter.convert(adminRepository.findAll());
    }
}
