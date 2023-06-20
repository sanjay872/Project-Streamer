package com.projectstreamer.watchlistservice.controller;

import com.projectstreamer.watchlistservice.dto.WatchListDto;
import com.projectstreamer.watchlistservice.dtoService.WatchListDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/watchlist")
public class WatchListController {

    @Autowired
    private WatchListDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createWatchList",
            summary = "Create Watch List")
    public ResponseEntity createWatchList(@RequestBody WatchListDto watchListDto){
        return new ResponseEntity<Long>(dtoService.createWatchList(watchListDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    @Operation(
            operationId = "getWatchListById",
            summary = "Get WatchList By Id")
    public ResponseEntity getWatchListById(@PathVariable("id") Long id){
        return new ResponseEntity<WatchListDto>(dtoService.getWatchListById(id),HttpStatus.OK);
    }

    @PutMapping()
    @Operation(
            operationId = "updateWatchListName",
            summary = "Update WatchList Name")
    public ResponseEntity updateWatchListName(@RequestParam Long id, @RequestParam String newName){
        dtoService.updateWatchListName(id,newName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    @Operation(
            operationId = "deleteWatchList",
            summary = "Delete WatchList")
    public ResponseEntity deleteWatchList(@PathVariable("id") Long id){
        dtoService.deleteWatchList(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
