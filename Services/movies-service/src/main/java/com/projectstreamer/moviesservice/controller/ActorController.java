package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.ActorDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dtoService.ActorDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    @Autowired
    private ActorDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createActor",
            summary = "Create Actor",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<Long> createActor(@RequestBody ActorDto actorDto){
        return new ResponseEntity<Long>(dtoService.createActor(actorDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            operationId = "getAllActor",
            summary = "Get All Actor",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<PageableDto> getAllActor(@RequestParam() @Min(value = 1,message = "Min 1 value required") int pageNo,
                                                      @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize){
        return new ResponseEntity<PageableDto>(dtoService.getAllActor(pageNo-1,pageSize),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateActor",
            summary = "Update Actor",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity updateActor(@RequestBody ActorDto actorDto){
        dtoService.updateActor(actorDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteActorById",
            summary = "Delete Actor By Id",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity deleteActorById(@PathVariable("id") Long id){
        dtoService.deleteActor(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
