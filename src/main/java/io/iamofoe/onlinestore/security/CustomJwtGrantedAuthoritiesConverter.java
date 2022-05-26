package io.iamofoe.onlinestore.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.ArrayList;
import java.util.Collection;

import static io.iamofoe.onlinestore.domain.model.Role.ROLE_ADMIN;
import static io.iamofoe.onlinestore.domain.model.Role.ROLE_USER;

public class CustomJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = jwtGrantedAuthoritiesConverter.convert(jwt);
        Collection<GrantedAuthority> updatedGrantedAuthorities = new ArrayList<>(grantedAuthorities);
        if (Admin.members.contains((String)jwt.getClaims().get("email"))) {
            updatedGrantedAuthorities.add(new SimpleGrantedAuthority(ROLE_ADMIN.name()));
        } else updatedGrantedAuthorities.add(new SimpleGrantedAuthority(ROLE_USER.name()));
        return updatedGrantedAuthorities;
    }
}