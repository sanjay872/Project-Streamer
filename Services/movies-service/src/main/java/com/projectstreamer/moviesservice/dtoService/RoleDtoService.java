package com.projectstreamer.moviesservice.dtoService;

import com.projectstreamer.moviesservice.dto.RoleDto;

public interface RoleDtoService {
    Long createRole(RoleDto roleDto);

    void updateRole(RoleDto roleDto);

    void deleteRoleById(Long id);
}
