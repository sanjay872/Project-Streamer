package com.streamer.authservice.dataMapper;

import com.streamer.authservice.dto.AuthorityDto;
import com.streamer.authservice.entity.Authority;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityDataMapper {
    Authority authorityDtoToAuthority(AuthorityDto authorityDto);
    AuthorityDto authorityToAuthorityDto(Authority authority);
    List<AuthorityDto> authoritiesToAuthoritiesDto(List<Authority> authorityList);
}
