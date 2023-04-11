package com.streamer.authservice.utils;

import com.streamer.authservice.entity.Account;
import com.streamer.authservice.entity.Authority;
import com.streamer.authservice.entity.Role;
import com.streamer.authservice.exception.exceptions.CustomException;
import com.streamer.authservice.service.AccountService;
import com.streamer.authservice.service.AuthorityService;
import com.streamer.authservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PreLoadData {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    public void loadRequiredData() throws Exception {

        var AUTHORITY_READ=loadAuthority("AUTHORITY_READ");
        var AUTHORITY_UPDATE=loadAuthority("AUTHORITY_UPDATE");
        var AUTHORITY_WRITE=loadAuthority("AUTHORITY_WRITE");
        var AUTHORITY_DELETE=loadAuthority("AUTHORITY_DELETE");

        Set<Authority> userAuthorities=new HashSet<>();
        userAuthorities.add(AUTHORITY_READ);

        Set<Authority> adminAuthorities=new HashSet<>();
        adminAuthorities.add(AUTHORITY_READ);
        adminAuthorities.add(AUTHORITY_WRITE);
        adminAuthorities.add(AUTHORITY_UPDATE);
        adminAuthorities.add(AUTHORITY_DELETE);

        // load roles
        loadRole("ROLE_USER",userAuthorities);
        loadRole("ROLE_ADMIN",adminAuthorities);

        //create admin
       try{
           accountService.createAdmin(Account.builder().email("admin@@streamer").password("admin@@power123").build());
       }
       catch (Exception e){
           System.out.println(e);
       }
    }

    private void loadRole(String role, Set<Authority> authorities){
        try{
            roleService.createRole(Role.builder().role(role).authorities(authorities).build());
        }catch (CustomException e){
            System.out.println(e);
        };
    }

    private Authority loadAuthority(String authority) {
        try {
            return authorityService.createAuthority(Authority.builder().authority(authority).build());
        }
        catch (CustomException e){
            System.out.print(e);
            return authorityService.getAuthorityByName(authority);
        }
    }

}
