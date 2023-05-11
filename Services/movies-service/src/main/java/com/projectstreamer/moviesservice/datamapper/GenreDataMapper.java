package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreDataMapper {
    GenreDto genreToGenreDto(Genre genre);
    Genre genreDtoToGenre(GenreDto genreDto);
}
