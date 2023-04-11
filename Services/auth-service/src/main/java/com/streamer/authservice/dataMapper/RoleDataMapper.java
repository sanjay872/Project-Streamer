package com.streamer.authservice.dataMapper;

import com.streamer.authservice.dto.RoleDto;
import com.streamer.authservice.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {AuthorityDataMapper.class})
public interface RoleDataMapper {

    RoleDto RoleToRoleDto(Role role);
    Role RoleDtoToRole(RoleDto roleDto);
    List<RoleDto> RolesToRoleDto(List<Role> roles);
}
