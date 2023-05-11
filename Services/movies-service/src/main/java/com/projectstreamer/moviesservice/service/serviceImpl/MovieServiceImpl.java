package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.MovieRepository;
import com.projectstreamer.moviesservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public Long createMovie(Movie movie) {

        return repository.save(movie).getId();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie=repository.findById(id);
        if(movie.isPresent())
            return movie.get();
        else
            throw new CustomNotFoundException("Movie not found");
    }

    @Override
    public Page<Movie> getAllMovie(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo,pageSize));
    }

    @Override
    public Page<Movie> getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, String genre, String rating, String language) {
        return repository.getMoviesByFilter(title,releasedYear,genre,rating,language,PageRequest.of(pageNo,pageSize));
    }

    @Override
    public void updateMovie(Movie movie) {
        repository.save(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Movie not found");
    }
}
