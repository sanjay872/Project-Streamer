package com.streamer.authservice.dtoService;

import com.streamer.authservice.dto.AuthorityDto;

import java.util.List;

public interface AuthorityDtoService {

    Long createAuthority(AuthorityDto authorityDto);

    List<AuthorityDto> getAllAuthority();

    AuthorityDto getAuthorityById(Long id);

    AuthorityDto getAuthorityByName(String authority);
    
    void updateAuthority(AuthorityDto authorityDto);

    void deleteAuthority(Long id);
}
