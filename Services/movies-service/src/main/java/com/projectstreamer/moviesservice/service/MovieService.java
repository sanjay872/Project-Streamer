package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.entity.Role;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface MovieService {
    Long createMovie(Movie movie);

    Movie getMovieById(Long id);

    Page<Movie> getAllMovie(int pageNo, int pageSize);

    Page<Movie> getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, Float rating, String genre, String language);

    void updateMovie(Movie movie);

    void deleteMovieById(Long id);

    void updateCast(Set<Role> roles, Long movieId);
}
