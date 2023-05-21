package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Role;

public interface RoleService {
    Long createRole(Role role);

    void updateRole(Role role);

    void deleteRoleById(Long id);
}
