package com.projectstreamer.moviesservice.dtoService.dtoServiceImpl;

import com.projectstreamer.moviesservice.datamapper.GenreDataMapper;
import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.dtoService.GenreDtoService;
import com.projectstreamer.moviesservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreDtoServiceImpl implements GenreDtoService {

    @Autowired
    private GenreService service;

    @Autowired
    private GenreDataMapper dataMapper;


    @Override
    public Long createGenre(GenreDto genreDto) {
        return service.createGenre(dataMapper.genreDtoToGenre(genreDto));
    }

    @Override
    public GenreDto getGenreByTitle(String title) {
        return dataMapper.genreToGenreDto(service.getGenreByTitle(title));
    }

    @Override
    public List<GenreDto> getAllGenre() {
        return service.getAllGenre().stream().map(dataMapper::genreToGenreDto).collect(Collectors.toList());
    }

    @Override
    public void updateGenre(GenreDto genreDto) {
        service.updateGenre(dataMapper.genreDtoToGenre(genreDto));
    }

    @Override
    public void deleteGenreById(Long id) {
        service.deleteGenreById(id);
    }
}
