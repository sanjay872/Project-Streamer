package com.projectstreamer.watchlistservice.controller;

import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.dtoService.ItemDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createItem",
            summary = "Create Item")
    public ResponseEntity createItem(@RequestBody ItemDto itemDto){
        return new ResponseEntity<Long>(dtoService.createItem(itemDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(
            operationId = "getItemById",
            summary = "Get Item By Id")
    public ResponseEntity getItemById(@PathVariable("id") Long id){
        return new ResponseEntity<ItemDto>(dtoService.getItemById(id),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateItem",
            summary = "Update Item")
    public ResponseEntity updateItem(@RequestBody ItemDto itemDto){
        dtoService.updateItem(itemDto);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteItem",
            summary = "Delete Item")
    public ResponseEntity deleteItem(@PathVariable("id") Long id){
        dtoService.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
