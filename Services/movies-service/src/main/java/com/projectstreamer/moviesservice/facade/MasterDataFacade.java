package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.MasterDataDto;

import java.util.List;

public interface MasterDataFacade {
    Long createMasterData(MasterDataDto masterDataDto);

    MasterDataDto getMasterDataByCode(String code);

    List<MasterDataDto> getAllMasterData();

    void updateMasterData(MasterDataDto masterDataDto);

    void deleteMasterDataById(Long id);
}
