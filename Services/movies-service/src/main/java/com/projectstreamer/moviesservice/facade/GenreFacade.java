package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.GenreDto;

import java.util.List;

public interface GenreFacade {
    Long createGenre(GenreDto genreDto);

    GenreDto getGenreByName(String name);

    void updateGenre(GenreDto genreDto);

    void deleteGenre(Long id);

    List<GenreDto> getAllGenre();
}
