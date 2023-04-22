package com.projectstreamer.moviesservice.facade.facadeImpl;

import com.projectstreamer.moviesservice.datamapper.SubMasterDataMapper;
import com.projectstreamer.moviesservice.dto.MasterDataDto;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.SubMasterDataDto;
import com.projectstreamer.moviesservice.entity.SubMasterData;
import com.projectstreamer.moviesservice.facade.SubMasterDataFacade;
import com.projectstreamer.moviesservice.service.SubMasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubMasterMasterDataFacadeImpl implements SubMasterDataFacade {

    @Autowired
    private SubMasterDataService service;

    @Autowired
    private SubMasterDataMapper dataMapper;

    @Override
    public Long createSubMasterData(SubMasterDataDto subMasterDataDto) {
        return service.createSubMasterData(dataMapper.subMasterDataDtoToSubMasterData(subMasterDataDto));
    }

    @Override
    public SubMasterDataDto getSubMasterDataByCode(String code) {
        return dataMapper.subMasterDataToSubMasterDataDto(service.getSubMasterDataByCode(code));
    }

    @Override
    public PageableDto getAllSubMasterData(int pageNo, int pageSize) {
        Page<SubMasterData> pagedSubMasterData=service.getAllSubMasterData(pageNo,pageSize);
        List<SubMasterDataDto> subMasterDataDto=pagedSubMasterData.getContent().stream().map(dataMapper::subMasterDataToSubMasterDataDto).collect(Collectors.toList());
        return new PageableDto<>(subMasterDataDto,pagedSubMasterData.getTotalElements());
    }

    @Override
    public List<SubMasterDataDto> getSubMasterDataByMasterDataCode(String masterDataCode) {
        return service.getSubMasterDataByMasterDataCode(masterDataCode).stream().map(dataMapper::subMasterDataToSubMasterDataDto).collect(Collectors.toList());
    }

    @Override
    public void updateSubMasterData(SubMasterDataDto subMasterDataDto) {
        service.updateSubMasterData(dataMapper.subMasterDataDtoToSubMasterData(subMasterDataDto));
    }

    @Override
    public void deleteSubMasterDataById(Long id) {
        service.deleteSubMasterDataById(id);
    }
}
