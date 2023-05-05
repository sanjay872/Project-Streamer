package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.MasterData;
import com.projectstreamer.moviesservice.exception.exceptions.CustomException;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.MasterDataRepository;
import com.projectstreamer.moviesservice.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterDataServiceImpl implements MasterDataService {

    @Autowired
    private MasterDataRepository repository;

    @Override
    public Long createMasterData(MasterData masterData) {
        if(repository.findByCode(masterData.getCode()).isPresent())
            throw new CustomException("Master Data Already Exist");
        return repository.save(masterData).getId();
    }

    @Override
    public MasterData getMasterDataByCode(String code) {
        Optional<MasterData> md=repository.findByCode(code);
        if(!md.isPresent())
            throw new CustomException("Master Data Already Exist");
        return md.get();
    }

    @Override
    public List<MasterData> getAllMasterData() {
        return repository.findAll();
    }

    @Override
    public void updateMasterData(MasterData masterData) {
        if(repository.getByCodeAndIdNot(masterData.getCode(),masterData.getId()).isPresent())
            throw new CustomException("Master Data Already Exist");
        repository.save(masterData);
    }

    @Override
    public void deleteMasterDataById(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Master Data Id Not Found");
    }
}
