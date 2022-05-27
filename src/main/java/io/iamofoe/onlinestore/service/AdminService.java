package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.dto.request.AdminRequest;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;

public interface AdminService {
    AddAdminDto addAdmin(AdminRequest request);
    void removeAdmin(AdminRequest request);
    AllAdminDto getAllAdmins();
    boolean isAdmin(String email);
}
