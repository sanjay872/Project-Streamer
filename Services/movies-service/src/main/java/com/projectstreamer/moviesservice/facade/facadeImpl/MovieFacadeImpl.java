package com.projectstreamer.moviesservice.facade.facadeImpl;

import com.projectstreamer.moviesservice.datamapper.MovieDataMapper;
import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.facade.MovieFacade;
import com.projectstreamer.moviesservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieFacadeImpl implements MovieFacade {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieDataMapper dataMapper;

    @Override
    public Long createMovie(MovieDto movieDto) {
        return service.createMovie(dataMapper.movieDtoToMovie(movieDto));
    }

    @Override
    public MovieDto getMovieById(Long id) {
        return dataMapper.movieToMovieDto(service.getMovieById(id));
    }

    @Override
    public PageableDto getAllMovie(int pageNo, int pageSize) {
        Page<Movie> moviesPaged=service.getAllMovie(pageNo,pageSize);
        List<MovieDto> movies=moviesPaged.getContent().stream().map(dataMapper::movieToMovieDto).toList();
        return new PageableDto<>(movies,moviesPaged.getTotalElements());
    }

    @Override
    public PageableDto getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, String genre, String rating, String language) {
        Page<Movie> moviesPaged=service.getMoviesByFilter(pageNo,pageSize,title,releasedYear,genre,rating,language);
        List<MovieDto> movies=moviesPaged.getContent().stream().map(dataMapper::movieToMovieDto).toList();
        return new PageableDto<>(movies,moviesPaged.getTotalElements());
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        service.updateMovie(dataMapper.movieDtoToMovie(movieDto));
    }

    @Override
    public void deleteMovieById(Long id) {
        service.deleteMovieById(id);
    }
}
