package com.streamer.authservice.controller;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.dto.PageableDto;
import com.streamer.authservice.dtoService.AccountDtoService;
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
    private AccountDtoService dtoService;

    @GetMapping("/all")
    @Operation(
            operationId = "getAllAccount",
            summary = "All Accounts Paginated")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<PageableDto> getAllAccount(@RequestParam() int pageNo,
                                                     @RequestParam() int pageSize,
                                                     @RequestParam(defaultValue = "id",required = false) String sortBy){
        return ResponseEntity.ok(dtoService.getAllAccount(pageNo,pageSize,sortBy));
    }

    @GetMapping("/{userId}")
    @Operation(
            operationId = "getAccountByUserId",
            summary = "Get a Account by UserId")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<AccountDto> getAccountByUserId(@PathVariable String userId){
        return ResponseEntity.ok(dtoService.getAccount(userId));
    }

    @PutMapping("/email")
    @Operation(
            operationId = "updateEmail",
            summary = "Change Email")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity updateEmail(@RequestBody AccountDto account){
        dtoService.updateEmail(account);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    @Operation(
            operationId = "updatePassword",
            summary = "Change Password")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity updatePassword(@RequestBody AccountDto account){
        dtoService.updatePassword(account);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{userId}")
    @Operation(
            operationId = "deleteAccountByUserId",
            summary = "Delete a Account using UserId")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity deleteAccountByUserId(@PathVariable("userId") String userId){
        dtoService.deleteAccount(userId);
        return ResponseEntity.ok().build();
    }

}
