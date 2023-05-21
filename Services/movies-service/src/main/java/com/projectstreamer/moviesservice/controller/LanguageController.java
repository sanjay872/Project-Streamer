package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.LanguageDto;
import com.projectstreamer.moviesservice.dtoService.LanguageDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController {

    @Autowired
    private LanguageDtoService dtoService;

    @PostMapping()
    @Operation(
            operationId = "createLanguage",
            summary = "Create Language")
    public ResponseEntity<Long> createLanguage(@RequestBody LanguageDto languageDto){
        return new ResponseEntity<Long>(dtoService.createLanguage(languageDto), HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    @Operation(
            operationId = "getLanguageByTitle",
            summary = "Get Language By Title")
    public ResponseEntity getLanguageByTitle(@PathVariable("title") String title){
        return new ResponseEntity<LanguageDto>(dtoService.getLanguageByTitle(title),HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllLanguage",
            summary = "Get All Language")
    public ResponseEntity<List<LanguageDto>> getAllLanguage()
    {
        return new ResponseEntity<List<LanguageDto>>(dtoService.getAllLanguage(),HttpStatus.OK);
    }

    @PutMapping()
    @Operation(
            operationId = "updateLanguage",
            summary = "Update Language")
    public ResponseEntity updateLanguage(@RequestBody LanguageDto languageDto)
    {
        dtoService.updateLanguage(languageDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteLanguageById",
            summary = "Delete Language By Id")
    public ResponseEntity deleteLanguageById(@PathVariable("id") Long id)
    {
        dtoService.deleteLanguageById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
