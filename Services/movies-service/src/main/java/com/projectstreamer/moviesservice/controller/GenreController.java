package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.GenreDto;
import com.projectstreamer.moviesservice.dtoService.GenreDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    private GenreDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createGenre",
            summary = "Create Genre")
    public ResponseEntity<Long> createGenre(@RequestBody GenreDto genreDto){
        return new ResponseEntity<Long>(dtoService.createGenre(genreDto), HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    @Operation(
            operationId = "getGenreByTitle",
            summary = "Get Genre By Title")
    public ResponseEntity<GenreDto> getGenreByTitle(@PathVariable("title") String title){
        return new ResponseEntity<GenreDto>(dtoService.getGenreByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllGenre",
            summary = "Get All Genre")
    public ResponseEntity<List<GenreDto>> getAllGenre(){
        return new ResponseEntity<List<GenreDto>>(dtoService.getAllGenre(),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateGenre",
            summary = "Update Genre")
    public ResponseEntity updateGenre(@RequestBody GenreDto genreDto){
        dtoService.updateGenre(genreDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteGenreById",
            summary = "Delete Genre By Id")
    public ResponseEntity deleteGenreById(@PathVariable("id") Long id){
        dtoService.deleteGenreById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
