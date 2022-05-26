package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;

public interface AdminService {
    AddAdminDto addAdmin(String email);
    void removeAdmin(String email);
    AllAdminDto getAllAdmins();
}
