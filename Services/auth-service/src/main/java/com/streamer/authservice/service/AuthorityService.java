package com.streamer.authservice.service;

import com.streamer.authservice.entity.Authority;

import java.util.List;

public interface AuthorityService {

    Authority createAuthority(Authority authority);

    List<Authority> getAllAuthority();

    Authority getAuthorityById(Long id);

    Authority getAuthorityByName(String authority);

    void updateAuthority(Authority authority);

    void deleteAuthority(Long id);
}
