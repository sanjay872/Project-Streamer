package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Actor;
import org.springframework.data.domain.Page;

public interface ActorService {
    Long createActor(Actor actor);

    Page<Actor> getAllActor(int pageNo, int pageSize);

    void updateActor(Actor actor);

    void deleteActor(Long id);
}
