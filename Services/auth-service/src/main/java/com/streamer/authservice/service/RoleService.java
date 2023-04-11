package com.streamer.authservice.service;

import com.streamer.authservice.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Long createRole(Role role);

    void updateRole(Role role);

    List<Role> getAllRole();

    void deleteRole(Long id);

    Role getRoleByName(String role);

    Role getRoleById(Long id);

    void addAuthoritiesToRole(String role, Set<String> authorities);
}
