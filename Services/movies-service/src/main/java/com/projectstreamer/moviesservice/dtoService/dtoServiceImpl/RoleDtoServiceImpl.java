package com.projectstreamer.moviesservice.dtoService.dtoServiceImpl;

import com.projectstreamer.moviesservice.datamapper.RoleDataMapper;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.dtoService.RoleDtoService;
import com.projectstreamer.moviesservice.entity.Role;
import com.projectstreamer.moviesservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDtoServiceImpl implements RoleDtoService {

    @Autowired
    private RoleDataMapper dataMapper;

    @Autowired
    private RoleService service;

    @Override
    public Long createRole(RoleDto roleDto) {
        return service.createRole(dataMapper.roleDtoToRole(roleDto));
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        service.updateRole(dataMapper.roleDtoToRole(roleDto));
    }

    @Override
    public void deleteRoleById(Long id) {
        service.deleteRoleById(id);
    }

    @Override
    public PageableDto getRolesByMovieId(Long id, int pageNo, int pageSize) {
        Page<Role> rolePaged=service.getRolesByMovieId(id,pageNo,pageSize);
        List<RoleDto> roles=rolePaged.getContent().stream().map(dataMapper::roleToRoleDto).collect(Collectors.toList());
        return new PageableDto(roles,rolePaged.getTotalElements());
    }
}
