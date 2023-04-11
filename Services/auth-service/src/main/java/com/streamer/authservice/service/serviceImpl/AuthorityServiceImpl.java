package com.streamer.authservice.service.serviceImpl;

import com.streamer.authservice.entity.Authority;
import com.streamer.authservice.exception.exceptions.CustomException;
import com.streamer.authservice.exception.exceptions.CustomNotFoundException;
import com.streamer.authservice.repository.AuthorityRepository;
import com.streamer.authservice.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository repository;

    @Override
    public Authority createAuthority(Authority authority) {
        if(repository.findByAuthority(authority.getAuthority()).isPresent())
            throw new CustomException("Already exist");
        else
            return repository.save(authority);
    }

    @Override
    public List<Authority> getAllAuthority() {
        return repository.findAll();
    }

    @Override
    public Authority getAuthorityById(Long id) {
        Optional<Authority> response=repository.findById(id);
        if(response.isPresent())
            return response.get();
        else
            throw new CustomNotFoundException("Authority not found");
    }

    @Override
    public Authority getAuthorityByName(String authority) {
        Optional<Authority> response=repository.findByAuthority(authority);
        if(response.isPresent())
            return response.get();
        else
            throw new CustomNotFoundException("Authority not found");
    }

    @Override
    public void updateAuthority(Authority authority) {
        if(repository.findById(authority.getId()).isEmpty())
            throw new CustomNotFoundException("Authority not found");
        else
            if(repository.findByAuthority(authority.getAuthority()).isPresent())
                throw new CustomException("The New Authority already exist");
            else
                repository.save(authority);
    }

    @Override
    public void deleteAuthority(Long id) {
        if(repository.findById(id).isEmpty())
            throw new CustomNotFoundException("Authority not found");
        else
            repository.deleteById(id);
    }
}
