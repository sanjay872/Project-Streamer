package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.StarringDto;
import com.projectstreamer.moviesservice.facade.StarringFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/starring")
public class StarringController {

    @Autowired
    private StarringFacade facade;

    @PostMapping
    public ResponseEntity<Long> createStarring(@RequestBody StarringDto starringDto){
        return new ResponseEntity<Long>(facade.createStarring(starringDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllStarring(@RequestParam() int pageNo,@RequestParam int pageSize){
        return new ResponseEntity<PageableDto>(facade.getAllStarring(pageNo,pageSize),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateStarring(@RequestBody StarringDto starringDto){
        facade.updateStarring(starringDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStarringById(@PathVariable("id") Long id){
        facade.deleteStarring(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
