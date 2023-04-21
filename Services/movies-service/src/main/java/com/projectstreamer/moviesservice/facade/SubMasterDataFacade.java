package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.SubMasterDataDto;

import java.util.List;

public interface SubMasterDataFacade {
    Long createSubMasterData(SubMasterDataDto subMasterDataDto);

    SubMasterDataDto getSubMasterDataByCode(String code);

    PageableDto getAllSubMasterData(int pageNo, int pageSize);

    List<SubMasterDataDto> getSubMasterDataByMasterDataCode(String masterDataCode);

    void updateSubMasterData(SubMasterDataDto subMasterDataDto);

    void deleteSubMasterDataById(Long id);
}
