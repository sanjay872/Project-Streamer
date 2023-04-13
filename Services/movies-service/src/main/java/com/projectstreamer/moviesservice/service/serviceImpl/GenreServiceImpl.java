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
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository repository;

    @Override
    public Long createGenre(Genre genre) {
        if(repository.findByName(genre.getName()).isPresent())
            throw new CustomException("Genre Already Exist");
        return repository.save(genre).getId();
    }

    @Override
    public Genre getGenreByName(String name) {
        Optional<Genre> genre=repository.findByName(name);
        if(genre.isPresent())
            return genre.get();
        else
            throw new CustomNotFoundException("Genre Not Found");
    }

    @Override
    public void updateGenre(Genre genre) {
        Optional<Genre> existGenre=repository.findById(genre.getId());
        if(existGenre.isPresent())
            if(repository.findByName(genre.getName()).isPresent())
                throw new CustomException("Updating Genre Name Already exist");
            else
                repository.save(genre);
        else
            throw new CustomException("Genre not found to update");
    }

    @Override
    public void deleteGenre(Long id) {
        Optional<Genre> existGenre=repository.findById(id);
        if(existGenre.isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Genre Not Found");
    }

    @Override
    public List<Genre> getAllGenre() {
        return repository.findAll();
    }
}
