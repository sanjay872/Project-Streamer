package com.projectstreamer.moviesservice.controller;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.SubMasterDataDto;
import com.projectstreamer.moviesservice.facade.SubMasterDataFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Operation(
            operationId = "createSubMasterData",
            summary = "Create Sub Master Data")
    public ResponseEntity<Long> createSubMasterData(@RequestBody SubMasterDataDto subMasterDataDto){
        return new ResponseEntity<Long>(facade.createSubMasterData(subMasterDataDto), HttpStatus.CREATED);
    }

    @GetMapping("/code/{code}")
    @Operation(
            operationId = "getSubMasterDataByCode",
            summary = "Get Sub Master Data By Code")
    public ResponseEntity getSubMasterDataByCode(@PathVariable("code") String code){
        return new ResponseEntity<SubMasterDataDto>(facade.getSubMasterDataByCode(code),HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            operationId = "getAllSubMasterData",
            summary = "Get All Sub Master Data")
    public ResponseEntity<PageableDto> getAllSubMasterData(@RequestParam @Min(value = 1,message = "Min 1 value required") int pageNo,
                                                           @RequestParam @Min(value = 1,message = "Min 1 value required") @Max(value = 100, message = "Max 100 value") int pageSize)
    {
        return new ResponseEntity<PageableDto>(facade.getAllSubMasterData(pageNo-1,pageSize),HttpStatus.OK);
    }

    @GetMapping("/masterData/{code}")
    @Operation(
            operationId = "getSubMasterDataByMasterDataCode",
            summary = "Get Sub Master Data By Master Data Code")
    public ResponseEntity<List<SubMasterDataDto>> getSubMasterDataByMasterDataCode(@RequestParam() String masterDataCode){
        return new ResponseEntity<List<SubMasterDataDto>>(facade.getSubMasterDataByMasterDataCode(masterDataCode),HttpStatus.OK);
    }

    @PutMapping()
    @Operation(
            operationId = "updateSubMasterData",
            summary = "Update Sub Master Data")
    public ResponseEntity updateSubMasterData(@RequestBody SubMasterDataDto subMasterDataDto)
    {
        facade.updateSubMasterData(subMasterDataDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(
            operationId = "deleteSubMasterDataById",
            summary = "Delete Sub Master Data By Id")
    public ResponseEntity deleteSubMasterDataById(@PathVariable("id") Long id)
    {
        facade.deleteSubMasterDataById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
