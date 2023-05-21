package com.projectstreamer.moviesservice.dtoService;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;

public interface MovieDtoService {
    Long createMovie(MovieDto movieDto);

    MovieDto getMovieById(Long id);

    PageableDto getAllMovie(int pageNo, int pageSize);

    PageableDto getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, String genre, String rating, String language);

    void updateMovie(MovieDto movieDto);

    void deleteMovieById(Long id);
}
