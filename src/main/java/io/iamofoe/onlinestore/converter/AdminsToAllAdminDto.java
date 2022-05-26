package io.iamofoe.onlinestore.converter;

import io.iamofoe.onlinestore.domain.model.Admin;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import io.iamofoe.onlinestore.dto.response.AllAdminDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminsToAllAdminDto implements Converter<List<Admin>, AllAdminDto> {

    @Override
    public AllAdminDto convert(List<Admin> admins) {
        return AllAdminDto.builder()
                .admins(convertAdmins(admins))
                .build();
    }

    private List<AddAdminDto> convertAdmins(List<Admin> admins) {
        return admins.stream()
                .map(admin -> AddAdminDto.builder()
                        .id(admin.getId())
                        .lastUpdated(admin.getLastUpdated())
                        .email(admin.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}
