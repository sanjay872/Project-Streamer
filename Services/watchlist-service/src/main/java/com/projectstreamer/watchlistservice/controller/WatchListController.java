package com.projectstreamer.watchlistservice.controller;

import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.dto.WatchListDto;
import com.projectstreamer.watchlistservice.dtoService.WatchListDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/watchlist")
public class WatchListController {

    @Autowired
    private WatchListDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createWatchList",
            summary = "Create Watch List",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity createWatchList(@RequestBody WatchListDto watchListDto){
        return new ResponseEntity<Long>(dtoService.createWatchList(watchListDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    @Operation(
            operationId = "getWatchListById",
            summary = "Get WatchList By Id",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity getWatchListById(@PathVariable("id") Long id){
        return new ResponseEntity<WatchListDto>(dtoService.getWatchListById(id),HttpStatus.OK);
    }

    @PutMapping()
    @Operation(
            operationId = "updateWatchListName",
            summary = "Update WatchList Name",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity updateWatchListName(@RequestParam Long id, @RequestParam String newName){
        dtoService.updateWatchListName(id,newName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    @Operation(
            operationId = "deleteWatchList",
            summary = "Delete WatchList",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity deleteWatchList(@PathVariable("id") Long id){
        dtoService.deleteWatchList(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/items")
    @Operation(
            operationId = "getWatchListItems",
            summary = "Get WatchList Items",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity getWatchListItems(@PathVariable("id") Long id){
        return new ResponseEntity<Set<ItemDto>>(dtoService.getWatchListItems(id),HttpStatus.OK);
    }

    @PatchMapping("/{id}/items")
    @Operation(
            operationId = "updateWatchListItems",
            summary = "Update WatchList Items",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity updateWatchListItems(@PathVariable("id") Long id, @RequestBody ItemDto itemDto){
        dtoService.updateWatchListItems(id,itemDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
