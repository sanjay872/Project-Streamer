package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Movie;
import org.springframework.data.domain.Page;

public interface MovieService {
    Long createMovie(Movie movie);

    Movie getMovieById(Long id);

    Page<Movie> getAllMovie(int pageNo, int pageSize);

    Page<Movie> getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, String genre, String rating, String language);

    void updateMovie(Movie movie);

    void deleteMovieById(Long id);
}
