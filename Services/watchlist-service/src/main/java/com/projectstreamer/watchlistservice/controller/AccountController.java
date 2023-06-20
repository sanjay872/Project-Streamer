package com.projectstreamer.watchlistservice.controller;

import com.projectstreamer.watchlistservice.dto.AccountDto;
import com.projectstreamer.watchlistservice.dtoService.AccountDtoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountDtoService dtoService;

    @PostMapping
    @Operation(
            operationId = "createAccount",
            summary = "Create Account")
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<Long>(dtoService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/userId/{userId}")
    @Operation(
            operationId = "getAccountByUserId",
            summary = "get Account by UserId")
    public ResponseEntity getAccountByUserId(@PathVariable("userId") String userId){
        return new ResponseEntity<AccountDto>(dtoService.getAccountByUserId(userId),HttpStatus.OK);
    }

    @PutMapping
    @Operation(
            operationId = "updateAccount",
            summary = "Update Account")
    public ResponseEntity updateAccount(@RequestBody AccountDto accountDto){
        dtoService.updateAccount(accountDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/userId/{userId}")
    @Operation(
            operationId = "deleteAccountByUserId",
            summary = "Delete Account By UserId")
    public ResponseEntity deleteAccountByUserId(@PathVariable("userId") String userId){
        dtoService.deleteAccountByUserId(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
