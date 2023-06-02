package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",uses = {ActorDataMapper.class})
public interface RoleDataMapper {

    @Named("buildMovieFromId")
    static Movie convertToMovie(Long id){
        return Movie.builder().id(id).build();
    }

    @Named("getIdFromMovie")
    static Long movieToMovieDto(Movie movie){
        return movie.getId();
    }


    @Mapping(source = "movie", target = "movie", qualifiedByName = "buildMovieFromId")
    Role roleDtoToRole(RoleDto roleDto);
    @Mapping(source = "movie", target = "movie", qualifiedByName = "getIdFromMovie")
    RoleDto roleToRoleDto(Role role);
}
