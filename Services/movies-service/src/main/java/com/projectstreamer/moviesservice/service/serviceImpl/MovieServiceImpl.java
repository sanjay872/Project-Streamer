package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.entity.Role;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.MovieRepository;
import com.projectstreamer.moviesservice.repository.RoleRepository;
import com.projectstreamer.moviesservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private RoleRepository roleRepository;

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
    public Page<Movie> getMoviesByFilter(int pageNo, int pageSize, String title, Long releasedYear,Float rating, String genre, String language) {
        return repository.findMovieByTitleIgnoreCaseContainingOrReleasedYearGreaterThanEqualOrRatingGreaterThanEqualOrGenreOrLanguages(title,releasedYear,rating,genre,language,PageRequest.of(pageNo,pageSize));
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

    @Override
    public void updateCast(Set<Role> roles, Long movieId) {
        Optional<Movie> existMovie=repository.findById(movieId);
        if(existMovie.isPresent()) {
            Movie updatedMovie=existMovie.get();
            Set<Role> newCast=new HashSet<>();
            roles.forEach(role -> {
                Optional<Role> existRole=roleRepository.findById(role.getId());
                if(existRole.isPresent())
                    newCast.add(existRole.get());
                else
                    throw new CustomNotFoundException("Role of id "+role.getId()+" not found!");
            });
            updatedMovie.setCast(newCast);
            repository.save(updatedMovie);
        }
        else{
            throw new CustomNotFoundException("Movie Id Not Found");
        }
    }
}
