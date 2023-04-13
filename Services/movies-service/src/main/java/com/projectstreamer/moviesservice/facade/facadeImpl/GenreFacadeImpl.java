package com.projectstreamer.moviesservice.facade.facadeImpl;

import com.projectstreamer.moviesservice.datamapper.GenreDataMapper;
import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.entity.Genre;
import com.projectstreamer.moviesservice.facade.GenreFacade;
import com.projectstreamer.moviesservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GenreFacadeImpl implements GenreFacade {

    @Autowired
    private GenreService service;

    @Autowired
    private GenreDataMapper dataMapper;

    @Override
    public Long createGenre(GenreDto genreDto) {
        return service.createGenre(dataMapper.genreDtoToGenre(genreDto));
    }

    @Override
    public GenreDto getGenreByName(String name) {
        return dataMapper.genreToGenreDto(service.getGenreByName(name));
    }

    @Override
    public void updateGenre(GenreDto genreDto) {
        service.updateGenre(dataMapper.genreDtoToGenre(genreDto));
    }

    @Override
    public void deleteGenre(Long id) {
        service.deleteGenre(id);
    }

    @Override
    public List<GenreDto> getAllGenre() {
        List<Genre> genres=service.getAllGenre();
        return genres.stream().map(dataMapper::genreToGenreDto).collect(Collectors.toList()) ;
    }
}
