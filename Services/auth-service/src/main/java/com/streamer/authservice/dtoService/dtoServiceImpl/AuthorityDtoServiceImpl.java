package com.streamer.authservice.dtoService.dtoServiceImpl;

import com.streamer.authservice.dataMapper.AuthorityDataMapper;
import com.streamer.authservice.dto.AuthorityDto;
import com.streamer.authservice.dtoService.AuthorityDtoService;
import com.streamer.authservice.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityDtoServiceImpl implements AuthorityDtoService {

    @Autowired
    private AuthorityService service;

    @Autowired
    private AuthorityDataMapper dataMapper;

    @Override
    public Long createAuthority(AuthorityDto authorityDto) {
        return service.createAuthority(dataMapper.authorityDtoToAuthority(authorityDto)).getId();
    }

    @Override
    public List<AuthorityDto> getAllAuthority() {
        return dataMapper.authoritiesToAuthoritiesDto(service.getAllAuthority());
    }

    @Override
    public AuthorityDto getAuthorityById(Long id) {
        return dataMapper.authorityToAuthorityDto(service.getAuthorityById(id));
    }

    @Override
    public AuthorityDto getAuthorityByName(String authority) {
        return dataMapper.authorityToAuthorityDto(service.getAuthorityByName(authority));
    }

    @Override
    public void updateAuthority(AuthorityDto authorityDto) {
        service.updateAuthority(dataMapper.authorityDtoToAuthority(authorityDto));
    }

    @Override
    public void deleteAuthority(Long id) {
        service.deleteAuthority(id);
    }
}
