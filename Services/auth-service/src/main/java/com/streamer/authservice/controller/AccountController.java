package com.streamer.authservice.controller;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.dto.PageableDto;
import com.streamer.authservice.facade.AccountFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountFacade facade;

    @GetMapping("/all")
    @Operation(
            operationId = "getAllAccount",
            summary = "All Accounts Paginated",
            security = {@SecurityRequirement(name = "BearerJWT")})
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<PageableDto> getAllAccount(@RequestParam() int pageNo,
                                                     @RequestParam() int pageSize,
                                                     @RequestParam(defaultValue = "id",required = false) String sortBy){
        return ResponseEntity.ok(facade.getAllAccount(pageNo,pageSize,sortBy));
    }

    @GetMapping("/{userId}")
    @Operation(
            operationId = "getAccountByUserId",
            summary = "Get a Account by UserId",
            security = {@SecurityRequirement(name = "BearerJWT")})
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<AccountDto> getAccountByUserId(@PathVariable String userId){
        return ResponseEntity.ok(facade.getAccount(userId));
    }

    @PutMapping("/email")
    @Operation(
            operationId = "updateEmail",
            summary = "Change Email",
            security = {@SecurityRequirement(name = "BearerJWT")})
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity updateEmail(@RequestBody AccountDto account){
        facade.updateEmail(account);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    @Operation(
            operationId = "updatePassword",
            summary = "Change Password",
            security = {@SecurityRequirement(name = "BearerJWT")})
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity updatePassword(@RequestBody AccountDto account){
        facade.updatePassword(account);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{userId}")
    @Operation(
            operationId = "deleteAccountByUserId",
            summary = "Delete a Account using UserId",
            security = {@SecurityRequirement(name = "BearerJWT")})
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity deleteAccountByUserId(@PathVariable("userId") String userId){
        facade.deleteAccount(userId);
        return ResponseEntity.ok().build();
    }

}
