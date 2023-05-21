package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Actor;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.ActorRepository;
import com.projectstreamer.moviesservice.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository repository;

    @Override
    public Long createActor(Actor actor) {
        return repository.save(actor).getId();
    }

    @Override
    public Page<Actor> getAllActor(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo,pageSize));
    }

    @Override
    public void updateActor(Actor actor) {
        if(repository.findById(actor.getId()).isPresent())
            repository.save(actor);
        else
            throw new CustomNotFoundException("Actor Id not found");
    }

    @Override
    public void deleteActor(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Actor Id not found");
    }
}
