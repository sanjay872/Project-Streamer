package com.projectstreamer.moviesservice.facade.facadeImpl;

import com.projectstreamer.moviesservice.datamapper.MasterDataMapper;
import com.projectstreamer.moviesservice.dto.MasterDataDto;
import com.projectstreamer.moviesservice.facade.MasterDataFacade;
import com.projectstreamer.moviesservice.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MasterFacadeImpl implements MasterDataFacade {

    @Autowired
    private MasterDataService service;

    @Autowired
    private MasterDataMapper dataMapper;


    @Override
    public Long createMasterData(MasterDataDto masterDataDto) {
        return service.createMasterData(dataMapper.masterDataDtoToMasterData(masterDataDto));
    }

    @Override
    public MasterDataDto getMasterDataByCode(String code) {
        return dataMapper.masterDataToMasterDataDto(service.getMasterDataByCode(code));
    }

    @Override
    public List<MasterDataDto> getAllMasterData() {
        return service.getAllMasterData().stream().map(dataMapper::masterDataToMasterDataDto).collect(Collectors.toList());
    }

    @Override
    public void updateMasterData(MasterDataDto masterDataDto) {
        service.updateMasterData(dataMapper.masterDataDtoToMasterData(masterDataDto));
    }

    @Override
    public void deleteMasterDataById(Long id) {
        service.deleteMasterDataById(id);
    }
}
