package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.StarringDto;
import com.projectstreamer.moviesservice.facade.StarringFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/starring")
public class StarringController {

    @Autowired
    private StarringFacade facade;

    @PostMapping
    @Operation(
            operationId = "createStarring",
            summary = "Create Starring")
    public ResponseEntity<Long> createStarring(@RequestBody StarringDto starringDto){
        return new ResponseEntity<Long>(facade.createStarring(starringDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            operationId = "getAllStarring",
            summary = "Get All Starring")
    public ResponseEntity<PageableDto> getAllStarring(@RequestParam() @Min(value = 1,message = "Min 1 value required") int pageNo,
                                                      @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize){
        return new ResponseEntity<PageableDto>(facade.getAllStarring(pageNo-1,pageSize),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateStarring",
            summary = "Update Starring")
    public ResponseEntity updateStarring(@RequestBody StarringDto starringDto){
        facade.updateStarring(starringDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteStarringById",
            summary = "Delete Starring By Id")
    public ResponseEntity deleteStarringById(@PathVariable("id") Long id){
        facade.deleteStarring(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
