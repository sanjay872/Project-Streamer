package com.streamer.authservice.controller;

import com.streamer.authservice.dto.AuthorityDto;
import com.streamer.authservice.dtoService.AuthorityDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authority")
public class AuthorityController {

    @Autowired
    private AuthorityDtoService dtoService;

    @PostMapping()
    @Operation(
            operationId = "createAuthority",
            summary = "create Authority")
    public ResponseEntity<Long> createAuthority(@RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(dtoService.createAuthority(authorityDto));
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllAuthority",
            summary = "Get All Authority")
    public ResponseEntity<List<AuthorityDto>> getAllAuthority(){
        return ResponseEntity.ok(dtoService.getAllAuthority());
    }

    @GetMapping("/id/{id}")
    @Operation(
            operationId = "getAuthorityById",
            summary = "Get an Authority by ID")
    public ResponseEntity<AuthorityDto> getAuthorityById(@PathVariable("id") Long id){
        return  ResponseEntity.ok(dtoService.getAuthorityById(id));
    }

    @GetMapping("{authority}")
    @Operation(
            operationId = "getAuthorityByName",
            summary = "Get an Authority By Name")
    public ResponseEntity<AuthorityDto> getAuthorityByName(@PathVariable("authority") String authority) {
        return ResponseEntity.ok(dtoService.getAuthorityByName(authority));
    }

    @PutMapping
    @Operation(
            operationId = "updateAuthority",
            summary = "Update Authority")
    public ResponseEntity updateAuthority(@RequestBody AuthorityDto authorityDto){
        dtoService.updateAuthority(authorityDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteAuthority",
            summary = "Delete Authority by ID")
    public ResponseEntity deleteAuthority(@PathVariable("id") Long id){
        dtoService.deleteAuthority(id);
        return  ResponseEntity.ok().build();
    }


}
