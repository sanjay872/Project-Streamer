package com.projectstreamer.moviesservice.dtoService;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.ActorDto;

public interface ActorDtoService {
    Long createActor(ActorDto actorDto);

    PageableDto getAllActor(int pageNo, int pageSize);

    void updateActor(ActorDto actorDto);

    void deleteActor(Long id);
}
