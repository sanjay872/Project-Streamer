package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Role;
import org.springframework.data.domain.Page;

public interface RoleService {
    Long createRole(Role role);

    void updateRole(Role role);

    void deleteRoleById(Long id);

    Page<Role> getRolesByMovieId(Long id, int pageNo, int pageSize);
}
