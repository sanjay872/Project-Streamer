package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Genre;

import java.util.List;

public interface GenreService {
    Long createGenre(Genre genre);

    Genre getGenreByName(String name);

    void updateGenre(Genre genreDtoToGenre);

    void deleteGenre(Long id);

    List<Genre> getAllGenre();
}
