package com.streamer.authservice.controller;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.dto.AuthResponseDto;
import com.streamer.authservice.dtoService.AccountDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AccountDtoService dtoService;

    @PostMapping()
    @Operation(
            operationId = "createAdmin",
            summary = "Create New Admin")
    public ResponseEntity<AuthResponseDto> createAdmin(@RequestBody AccountDto adminAccount){
        return new ResponseEntity<AuthResponseDto>(dtoService.createAdmin(adminAccount), HttpStatus.CREATED);
    }

}
