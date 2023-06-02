package com.projectstreamer.moviesservice.dtoService.dtoServiceImpl;

import com.projectstreamer.moviesservice.datamapper.MovieDataMapper;
import com.projectstreamer.moviesservice.datamapper.RoleDataMapper;
import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.entity.Movie;
import com.projectstreamer.moviesservice.dtoService.MovieDtoService;
import com.projectstreamer.moviesservice.entity.Role;
import com.projectstreamer.moviesservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieDtoServiceImpl implements MovieDtoService {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieDataMapper dataMapper;

    @Autowired
    private RoleDataMapper roleDataMapper;

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
    public PageableDto getMoviesByFilter(int pageNo, int pageSize, String title, String releasedYear, Float rating, String genre, String language) {
        Page<Movie> moviesPaged=service.getMoviesByFilter(pageNo,pageSize,title,releasedYear,rating,genre,language);
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

    @Override
    public void updateCast(Set<RoleDto> cast, Long movieId) {
        Set<Role> roles=cast.stream().map(roleDataMapper::roleDtoToRole).collect(Collectors.toSet());
        service.updateCast(roles,movieId);
    }
}
