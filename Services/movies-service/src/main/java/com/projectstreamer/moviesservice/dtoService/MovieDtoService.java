package com.projectstreamer.moviesservice.dtoService;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.RoleDto;

import java.util.Set;

public interface MovieDtoService {
    Long createMovie(MovieDto movieDto);

    MovieDto getMovieById(Long id);

    PageableDto getAllMovie(int pageNo, int pageSize);

    PageableDto getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, Float rating, String genre, String language);

    void updateMovie(MovieDto movieDto);

    void deleteMovieById(Long id);

    void updateCast(Set<RoleDto> cast, Long movieId);
}
