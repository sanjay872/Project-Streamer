package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.MasterDataDto;
import com.projectstreamer.moviesservice.facade.MasterDataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/masterData")
public class MasterDataController {

    @Autowired
    private MasterDataFacade facade;

    @PostMapping
    public ResponseEntity<Long> createMasterData(@RequestBody MasterDataDto masterDataDto){
        return new ResponseEntity<Long>(facade.createMasterData(masterDataDto), HttpStatus.CREATED);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<MasterDataDto> getMasterDataByCode(@PathVariable("code") String code){
        return new ResponseEntity<MasterDataDto>(facade.getMasterDataByCode(code),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MasterDataDto>> getAllMasterData(){
        return new ResponseEntity<List<MasterDataDto>>(facade.getAllMasterData(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateMasterData(@RequestBody MasterDataDto masterDataDto){
        facade.updateMasterData(masterDataDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMasterDataById(@PathVariable("id") Long id){
        facade.deleteMasterDataById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
