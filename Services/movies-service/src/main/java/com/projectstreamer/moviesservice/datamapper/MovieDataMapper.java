package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {SubMasterDataMapper.class})
public interface MovieDataMapper {
    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie movie);
}
