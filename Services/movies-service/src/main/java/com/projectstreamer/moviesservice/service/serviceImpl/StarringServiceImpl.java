package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Starring;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.StarringRepository;
import com.projectstreamer.moviesservice.service.StarringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StarringServiceImpl implements StarringService {

    @Autowired
    private StarringRepository repository;

    @Override
    public Long createStarring(Starring starring) {
        return repository.save(starring).getId();
    }

    @Override
    public Page<Starring> getAllStarring(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo,pageSize));
    }

    @Override
    public void updateStarring(Starring starring) {
        if(repository.findById(starring.getId()).isPresent())
            repository.save(starring);
        else
            throw new CustomNotFoundException("Starring Id not found");
    }

    @Override
    public void deleteStarring(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Starring Id not found");
    }
}
