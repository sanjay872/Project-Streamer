package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.GenreDto;
import java.util.List;

public interface GenreFacade {
    Long createGenre(GenreDto genreDto);

    GenreDto getGenreByTitle(String title);

    List<GenreDto> getAllGenre();

    void updateGenre(GenreDto genreDto);

    void deleteGenreById(Long id);
}
