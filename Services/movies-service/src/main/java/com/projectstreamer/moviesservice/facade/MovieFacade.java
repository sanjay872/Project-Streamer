package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;

import java.util.List;

public interface MovieFacade {
    Long createMovie(MovieDto movieDto);

    MovieDto getMovieById(Long id);

    PageableDto getAllMovie(int pageNo, int pageSize);

    PageableDto getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, String genre, String rating, String language);

    void updateMovie(MovieDto movieDto);

    void deleteMovieById(Long id);
}
