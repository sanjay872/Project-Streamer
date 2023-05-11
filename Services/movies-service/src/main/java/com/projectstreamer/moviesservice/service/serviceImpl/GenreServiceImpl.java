package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Genre;
import com.projectstreamer.moviesservice.exception.exceptions.CustomException;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.GenreRepository;
import com.projectstreamer.moviesservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repository;

    @Override
    public Long createGenre(Genre genre) {
        if(repository.findByTitle(genre.getTitle()).isPresent())
            throw new CustomException("Genre Already Exist");
        return repository.save(genre).getId();
    }

    @Override
    public Genre getGenreByTitle(String title) {
        Optional<Genre> genre=repository.findByTitle(title);
        if(!genre.isPresent())
            throw new CustomException("Genre Already Exist!");
        return genre.get();
    }

    @Override
    public List<Genre> getAllGenre() {
        return repository.findAll();
    }

    @Override
    public void updateGenre(Genre genre) {
        if(repository.getByTitleAndIdNot(genre.getTitle(),genre.getId()).isPresent())
            throw new CustomException("Genre Already Exist");
        repository.save(genre);
    }

    @Override
    public void deleteGenreById(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Genre Id Not Found");
    }
}
