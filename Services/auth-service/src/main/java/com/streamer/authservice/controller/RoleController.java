package com.streamer.authservice.controller;

import com.streamer.authservice.dto.RoleDto;
import com.streamer.authservice.facade.RoleFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleFacade facade;

    @PostMapping
    @Operation(
            operationId = "createRole",
            summary = "Create New Role",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<Long> createRole(@RequestBody RoleDto role) {
        return ResponseEntity.ok(facade.createRole(role));
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllRole",
            summary = "Get all Roles",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<List<RoleDto>> getAllRole() {
        return ResponseEntity.ok(facade.getAllRole());
    }

    @GetMapping("/id/{id}")
    @Operation(
            operationId = "getRoleById",
            summary = "Get a Role by ID",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(facade.getRoleById(id));
    }

    @GetMapping("/{role}")
    @Operation(
            operationId = "getRoleByName",
            summary = "Get a Role By Name",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity<RoleDto> getRoleByName(@PathVariable("role") String role) {
        return ResponseEntity.ok(facade.getRoleByName(role));
    }

    @PatchMapping
    @Operation(
            operationId = "updateRole",
            summary = "Update Role",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity updateRole(@RequestBody RoleDto role) {
        facade.updateRole(role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteRole",
            summary = "Delete a Role by ID",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity deleteRole(@PathVariable("id") Long id) {
        facade.deleteRole(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authoritiesToRole")
    @Operation(
            operationId = "addAuthoritiesToRole",
            summary = "add new Authorities to role",
            security = {@SecurityRequirement(name = "BearerJWT")})
    public ResponseEntity addAuthoritiesToRole(@RequestParam("role") String role, @RequestParam("authorities") Set<String> authorities){
        facade.addAuthoritiesToRole(role,authorities);
        return ResponseEntity.ok().build();
    }
}