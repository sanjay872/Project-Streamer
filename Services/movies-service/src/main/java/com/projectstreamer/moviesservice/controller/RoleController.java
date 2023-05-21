package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.dtoService.RoleDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleDtoService dtoService;

    @PostMapping
    public ResponseEntity<Long> createRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<Long>(dtoService.createRole(roleDto), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity updateRole(@RequestBody RoleDto roleDto){
        dtoService.updateRole(roleDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoleById(@PathVariable("id") Long id){
        dtoService.deleteRoleById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
