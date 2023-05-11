package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Genre;

import java.util.List;

public interface GenreService {

    Long createGenre(Genre genre);

    Genre getGenreByTitle(String title);

    List<Genre> getAllGenre();

    void updateGenre(Genre genre);

    void deleteGenreById(Long id);
}
