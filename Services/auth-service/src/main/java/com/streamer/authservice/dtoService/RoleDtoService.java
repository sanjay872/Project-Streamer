package com.streamer.authservice.dtoService;

import com.streamer.authservice.dto.RoleDto;

import java.util.List;
import java.util.Set;

public interface RoleDtoService {
    Long createRole(RoleDto role);

    List<RoleDto> getAllRole();

    RoleDto getRoleByName(String role);

    void updateRole(RoleDto role);

    void deleteRole(Long id);

    RoleDto getRoleById(Long id);

    void addAuthoritiesToRole(String role, Set<String> authorities);
}
