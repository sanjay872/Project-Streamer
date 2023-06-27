package com.projectstreamer.watchlistservice.controller;

import com.projectstreamer.watchlistservice.dto.ItemCategoryDto;
import com.projectstreamer.watchlistservice.dtoService.ItemCategoryDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itemCategory")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createItemCategory",
            summary = "Create Item Category")
    public ResponseEntity createItemCategory(@RequestBody ItemCategoryDto itemCategoryDto){
        return new ResponseEntity<Long>(dtoService.createItemCategory(itemCategoryDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            operationId = "getAllItemCategory",
            summary = "Get All Item Category")
    public ResponseEntity getAllItemCategory(){
        return new ResponseEntity<List<ItemCategoryDto>>(dtoService.getAllItemCategory(),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateItemCategory",
            summary = "Update Item Category")
    public ResponseEntity updateItemCategory(@RequestBody ItemCategoryDto itemCategoryDto){
        dtoService.updateItemCategory(itemCategoryDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteItemCategory",
            summary = "Delete Item Category")
    public ResponseEntity deleteItemCategory(@PathVariable("id") Long id){
        dtoService.deleteItemCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
