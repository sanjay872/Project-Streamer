package com.streamer.authservice.controller;

import com.streamer.authservice.dto.AuthDto;
import com.streamer.authservice.dto.AuthResponseDto;
import com.streamer.authservice.dtoService.AccountDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AccountDtoService dtoService;

    @PostMapping("/register")
    @Operation(
            operationId = "getAllAccount",
            summary = "Register New Account")
    public ResponseEntity<AuthResponseDto> registerNewAccount(@RequestBody AuthDto auth){
        return ResponseEntity.ok(dtoService.registerAccount(auth));
    }

    @PostMapping("/login")
    @Operation(
            operationId = "authenticateAccount",
            summary = "Account Login")
    public ResponseEntity<AuthResponseDto> authenticateAccount(@RequestBody AuthDto auth){
        return ResponseEntity.ok(dtoService.authenticateAccount(auth));
    }
}
