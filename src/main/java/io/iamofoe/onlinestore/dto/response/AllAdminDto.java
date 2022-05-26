package io.iamofoe.onlinestore.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AllAdminDto {
    List<AddAdminDto> admins;
}
