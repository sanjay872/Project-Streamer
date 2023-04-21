package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.SubMasterDataDto;
import com.projectstreamer.moviesservice.facade.SubMasterDataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subData")
public class SubMasterDataController {

    @Autowired
    private SubMasterDataFacade facade;

    @PostMapping()
    public ResponseEntity<Long> createSubMasterData(@RequestBody SubMasterDataDto subMasterDataDto){
        return new ResponseEntity<Long>(facade.createSubMasterData(subMasterDataDto), HttpStatus.CREATED);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getSubMasterDataByCode(@PathVariable("code") String code){
        return new ResponseEntity<SubMasterDataDto>(facade.getSubMasterDataByCode(code),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<PageableDto> getAllSubMasterData(@RequestParam() int pageNo,
                                                           @RequestParam() int pageSize)
    {
        return new ResponseEntity<PageableDto>(facade.getAllSubMasterData(pageNo,pageSize),HttpStatus.OK);
    }

    @GetMapping("/masterData/{code}")
    public ResponseEntity<List<SubMasterDataDto>> getSubMasterDataByMasterDataCode(@RequestParam() String masterDataCode){
        return new ResponseEntity<List<SubMasterDataDto>>(facade.getSubMasterDataByMasterDataCode(masterDataCode),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updateSubMasterData(@RequestBody SubMasterDataDto subMasterDataDto)
    {
        facade.updateSubMasterData(subMasterDataDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubMasterDataById(@PathVariable("id") Long id)
    {
        facade.deleteSubMasterDataById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
