package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.SubMasterData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubMasterDataService {
    Long createSubMasterData(SubMasterData subMasterData);

    SubMasterData getSubMasterDataByCode(String code);

    Page<SubMasterData> getAllSubMasterData(int pageNo, int pageSize);

    List<SubMasterData> getSubMasterDataByMasterDataCode(String masterDataCode);

    void updateSubMasterData(SubMasterData subMasterData);

    void deleteSubMasterDataById(Long id);
}
