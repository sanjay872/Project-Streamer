package com.projectstreamer.moviesservice.dtoService.dtoServiceImpl;

import com.projectstreamer.moviesservice.datamapper.ActorDataMapper;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.ActorDto;
import com.projectstreamer.moviesservice.entity.Actor;
import com.projectstreamer.moviesservice.dtoService.ActorDtoService;
import com.projectstreamer.moviesservice.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorDtoServiceImpl implements ActorDtoService {

    @Autowired
    private ActorService service;

    @Autowired
    private ActorDataMapper dataMapper;

    @Override
    public Long createActor(ActorDto actorDto) {
        return service.createActor(dataMapper.actorDtoToActor(actorDto));
    }

    @Override
    public PageableDto getAllActor(int pageNo, int pageSize) {
        Page<Actor> pagedStarring=service.getAllActor(pageNo,pageSize);
        List<ActorDto> actorDto =pagedStarring.getContent().stream().map(dataMapper::actorToActorDto).collect(Collectors.toList());
        return new PageableDto<>(actorDto,pagedStarring.getTotalElements());
    }

    @Override
    public void updateActor(ActorDto actorDto) {
        service.updateActor(dataMapper.actorDtoToActor(actorDto));
    }

    @Override
    public void deleteActor(Long id) {
        service.deleteActor(id);
    }
}
