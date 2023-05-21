package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.ActorDto;
import com.projectstreamer.moviesservice.entity.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorDataMapper {
    Actor actorDtoToActor(ActorDto actorDto);
    ActorDto actorToActorDto(Actor actor);
}
