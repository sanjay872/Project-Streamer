package com.streamer.authservice.service.serviceImpl;

import com.streamer.authservice.entity.Authority;
import com.streamer.authservice.entity.Role;
import com.streamer.authservice.exception.exceptions.CustomException;
import com.streamer.authservice.exception.exceptions.CustomNotFoundException;
import com.streamer.authservice.repository.RoleRepository;
import com.streamer.authservice.service.AuthorityService;
import com.streamer.authservice.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository repository;

    @Autowired
    private AuthorityService authorityService;

    @Override
    @Transactional
    public Long createRole(Role role) {
        if(repository.findByRole(role.getRole()).isPresent())
            throw new CustomException("Already exist");
        else {
            Set<Authority> authorities=new HashSet<>();
            role.getAuthorities().forEach(authority -> {
                if(authority.getAuthority().isEmpty())
                    authorities.add(authorityService.getAuthorityById(authority.getId()));
                else
                    authorities.add(authorityService.getAuthorityByName(authority.getAuthority()));
            });
            role.setAuthorities(authorities);
            return repository.save(role).getId();
        }
    }

    @Override
    public void updateRole(Role role) {
        if(repository.findById(role.getId()).isEmpty())
            throw new CustomNotFoundException("Role not found");
        else
            if(repository.findByRole(role.getRole()).isPresent())
                throw new CustomException("The new Role Already exist");
            else
                repository.save(role).getId();
    }

    @Override
    public List<Role> getAllRole() {
        return repository.findAll();
    }

    @Override
    public Role getRoleByName(String role) {
        Optional<Role> response=repository.findByRole(role);
        if(response.isPresent())
            return response.get();
        else
            throw new CustomNotFoundException("Role not found");
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> response=repository.findById(id);
        if(response.isPresent())
            return response.get();
        else
            throw new CustomNotFoundException("Role not found");
    }

    @Override
    public void addAuthoritiesToRole(String role, Set<String> authorities) {
        Optional<Role> existRole=repository.findByRole(role);
        if(existRole.isPresent()){
            Set<Authority> existAuthorities=new HashSet<>();
            authorities.forEach((authority)->{
                existAuthorities.add(authorityService.getAuthorityByName(authority));
            });
            Role updatedRole=existRole.get();
            updatedRole.setAuthorities(existAuthorities);
            repository.save(updatedRole);
        }
    }

    @Override
    public void deleteRole(Long id) {
        Optional<Role> response=repository.findById(id);
        if(response.isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Role not found");
    }
}
