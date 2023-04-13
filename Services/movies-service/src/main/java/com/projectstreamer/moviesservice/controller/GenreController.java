package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.facade.GenreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {

    @Autowired
    private GenreFacade facade;

    @PostMapping
    public ResponseEntity<Long> createGenre(@RequestBody GenreDto genreDto)
    {
        return new ResponseEntity<Long>(facade.createGenre(genreDto), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<GenreDto> getGenreByName(@PathVariable("name") String name)
    {
        return new ResponseEntity<GenreDto>(facade.getGenreByName(name),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDto>> getAllGenre(){
        return new ResponseEntity<List<GenreDto>>(facade.getAllGenre(),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updateGenre(@RequestBody GenreDto genreDto)
    {
        facade.updateGenre(genreDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable("id") Long id){
        facade.deleteGenre(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
