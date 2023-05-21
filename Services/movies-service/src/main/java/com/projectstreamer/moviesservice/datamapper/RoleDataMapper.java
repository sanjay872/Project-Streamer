package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ActorDataMapper.class,MovieDataMapper.class})
public interface RoleDataMapper {
    Role roleDtoToRole(RoleDto roleDto);
    RoleDto roleToRoleDto(Role role);
}
