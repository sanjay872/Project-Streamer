package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Role;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.RoleRepository;
import com.projectstreamer.moviesservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Long createRole(Role role) {
        return repository.save(role).getId();
    }

    @Override
    public void updateRole(Role role) {
        if(repository.existsById(role.getId()))
            repository.save(role);
        else
            throw new CustomNotFoundException("Role Id Not Found");
    }

    @Override
    public void deleteRoleById(Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Role Id Not Found");
    }
}
