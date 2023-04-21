package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.MasterData;
import org.springframework.data.util.Optionals;

import java.util.List;

public interface MasterDataService {

    Long createMasterData(MasterData masterData);

    MasterData getMasterDataByCode(String code);

    List<MasterData> getAllMasterData();

    void updateMasterData(MasterData masterData);

    void deleteMasterDataById(Long id);
}
