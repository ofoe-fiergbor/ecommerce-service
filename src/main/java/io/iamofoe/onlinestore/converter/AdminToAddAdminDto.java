package io.iamofoe.onlinestore.converter;

import io.iamofoe.onlinestore.domain.model.Admin;
import io.iamofoe.onlinestore.dto.response.AddAdminDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminToAddAdminDto implements Converter<Admin, AddAdminDto> {
    @Override
    public AddAdminDto convert(Admin admin) {
        return AddAdminDto.builder()
                .id(admin.getId())
                .email(admin.getEmail())
                .lastUpdated(admin.getLastUpdated())
                .build();
    }
}
