package com.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_DISPATCHER("dispatcher"),
    ROLE_ADMIN("admin"),
    ROLE_DRIVER("driver");

    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
