package com.streamer.authservice.dtoService.dtoServiceImpl;

import com.streamer.authservice.dataMapper.RoleDataMapper;
import com.streamer.authservice.dto.RoleDto;
import com.streamer.authservice.dtoService.RoleDtoService;
import com.streamer.authservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleDtoServiceImpl implements RoleDtoService {

    @Autowired
    private RoleService service;

    @Autowired
    private RoleDataMapper dataMapper;

    @Override
    public Long createRole(RoleDto role) {
        return service.createRole(dataMapper.RoleDtoToRole(role));
    }

    @Override
    public List<RoleDto> getAllRole() {
        return dataMapper.RolesToRoleDto(service.getAllRole());
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return dataMapper.RoleToRoleDto(service.getRoleById(id));
    }

    @Override
    public void addAuthoritiesToRole(String role, Set<String> authorities) {
        service.addAuthoritiesToRole(role,authorities);
    }

    @Override
    public RoleDto getRoleByName(String role) {
        return dataMapper.RoleToRoleDto(service.getRoleByName(role));
    }

    @Override
    public void updateRole(RoleDto role) {
        service.updateRole(dataMapper.RoleDtoToRole(role));
    }

    @Override
    public void deleteRole(Long id) {
        service.deleteRole(id);
    }

}
