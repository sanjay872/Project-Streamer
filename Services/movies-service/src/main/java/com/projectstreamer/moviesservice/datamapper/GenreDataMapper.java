package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.entity.Genre;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GenreDataMapper {
    Genre genreDtoToGenre(GenreDto genreDto);
    GenreDto genreToGenreDto(Genre genre);
}
