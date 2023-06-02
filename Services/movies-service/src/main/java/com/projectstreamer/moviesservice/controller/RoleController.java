package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.RoleDto;
import com.projectstreamer.moviesservice.dtoService.RoleDtoService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

    @GetMapping()
    public ResponseEntity<PageableDto> getRolesByMovieId(@RequestParam("movieId") Long id,
                                                         @RequestParam("pageNo") @Min(value = 1,message = "Min 1 value required") int pageNo,
                                                         @RequestParam("pageSize") @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize){
        return new ResponseEntity<PageableDto>(dtoService.getRolesByMovieId(id,pageNo-1,pageSize),HttpStatus.OK);
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
