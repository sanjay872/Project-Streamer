package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.MovieDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.dtoService.MovieDtoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createMovie",
            summary = "Create Movie")
    public ResponseEntity<Long> createMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<Long>(dtoService.createMovie(movieDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    @Operation(
            operationId = "getMovieById",
            summary = "Get Movie By Id")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id){
        return new ResponseEntity<MovieDto>(dtoService.getMovieById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllMovie",
            summary = "Get All Movie")
    public ResponseEntity<PageableDto> getAllMovie(@RequestParam @Min(value = 1,message = "Min 1 value required")  int pageNo,
                                                         @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize){
        return new ResponseEntity<PageableDto>(dtoService.getAllMovie(pageNo-1,pageSize),HttpStatus.OK);
    }

    @GetMapping("/filter")
    @Operation(
            operationId = "getMovieByFilter",
            summary = "Get Movies by Filter")
    public ResponseEntity<PageableDto> getMovieByFilter(@RequestParam @Min(value = 1,message = "Min 1 value required")  int pageNo,
                                                              @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize,
                                                              @RequestParam(required = false) String title, @RequestParam(required = false) String releasedYear,
                                                              @RequestParam(required = false) String genre, @RequestParam(required = false) Float rating,
                                                              @RequestParam(required = false) String language){
        return new ResponseEntity<PageableDto>(dtoService.getMoviesByFilter(pageNo-1,pageSize,title,releasedYear,rating,genre,language), HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateMovie",
            summary = "Update Movie")
    public ResponseEntity updateMovie(@RequestBody MovieDto movieDto){
        dtoService.updateMovie(movieDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/cast")
    @Operation(
            operationId = "updateCast",
            summary = "update Cast")
    public ResponseEntity updateCast(@RequestBody Set<RoleDto> cast, @RequestParam("movieId") Long movieId){
        dtoService.updateCast(cast,movieId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteMovieById",
            summary = "Delete Movie By Id")
    public ResponseEntity deleteMovieById(@PathVariable Long id){
        dtoService.deleteMovieById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
