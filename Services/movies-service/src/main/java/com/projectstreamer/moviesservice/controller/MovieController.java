package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.facade.MovieFacade;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieFacade facade;

    @PostMapping
    public ResponseEntity<Long> createMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<Long>(facade.createMovie(movieDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id){
        return new ResponseEntity<MovieDto>(facade.getMovieById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<PageableDto> getAllMovie(@RequestParam @Min(value = 1,message = "Min 1 value required")  int pageNo,
                                                         @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize){
        return new ResponseEntity<PageableDto>(facade.getAllMovie(pageNo,pageSize),HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<PageableDto> getMovieByFilter(@RequestParam @Min(value = 1,message = "Min 1 value required")  int pageNo,
                                                              @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize,
                                                              @RequestParam(required = false) String title, @RequestParam(required = false) String releasedYear,
                                                              @RequestParam(required = false) String genre, @RequestParam(required = false) String rating,
                                                              @RequestParam(required = false) String language){
        return new ResponseEntity<PageableDto>(facade.getMoviesByFilter(pageNo,pageSize,title,releasedYear,genre,rating,language), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateMovie(@RequestBody MovieDto movieDto){
        facade.updateMovie(movieDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovieById(@PathVariable Long id){
        facade.deleteMovieById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
