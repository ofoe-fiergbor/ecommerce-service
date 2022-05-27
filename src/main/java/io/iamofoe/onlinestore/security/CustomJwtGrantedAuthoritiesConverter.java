package io.iamofoe.onlinestore.security;

import io.iamofoe.onlinestore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.ArrayList;
import java.util.Collection;

import static io.iamofoe.onlinestore.domain.model.Role.*;

@RequiredArgsConstructor
public class CustomJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    private final AdminService adminService;

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = jwtGrantedAuthoritiesConverter.convert(jwt);
        Collection<GrantedAuthority> updatedGrantedAuthorities = new ArrayList<>(grantedAuthorities);
        String email = (String) jwt.getClaims().get("email");
        if (MasterAdmin.members.contains(email)) {
            updatedGrantedAuthorities.add(new SimpleGrantedAuthority(ROLE_MASTER_ADMIN.name()));
        }
        if (adminService.isAdmin(email)) {
            updatedGrantedAuthorities.add(new SimpleGrantedAuthority(ROLE_ADMIN.name()));
        }
        updatedGrantedAuthorities.add(new SimpleGrantedAuthority(ROLE_USER.name()));
        return updatedGrantedAuthorities;
    }
}