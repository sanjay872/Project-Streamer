package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.SubMasterData;
import com.projectstreamer.moviesservice.exception.exceptions.CustomException;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.SubMasterDataRepository;
import com.projectstreamer.moviesservice.service.SubMasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubMasterMasterDataServiceImpl implements SubMasterDataService {

    @Autowired
    private SubMasterDataRepository repository;

    @Override
    public Long createSubMasterData(SubMasterData subMasterData) {
        if(repository.findByCode(subMasterData.getCode()).isPresent())
            throw new CustomException("Sub Master Data Already Exist");
        return repository.save(subMasterData).getId();
    }

    @Override
    public SubMasterData getSubMasterDataByCode(String code) {
        Optional<SubMasterData> smd=repository.findByCode(code);
        if(!smd.isPresent())
            throw new CustomException("Sub Master Data Already Exist");
        return smd.get();
    }

    @Override
    public List<SubMasterData> getAllSubMasterData(int pageNo, int pageSize) {
        return repository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }

    @Override
    public List<SubMasterData> getSubMasterDataByMasterDataCode(String masterDataCode) {
        return repository.findAllByMasterDataCode(masterDataCode);
    }

    @Override
    public void updateSubMasterData(SubMasterData subMasterData) {
        if(repository.getCodeAndNotId(subMasterData.getCode(),subMasterData.getId()).isPresent())
            throw new CustomException("Sub Master Data Already Exist");
        repository.save(subMasterData);
    }

    @Override
    public void deleteSubMasterDataById(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Sub Master Data Id Not Found");
    }
}
