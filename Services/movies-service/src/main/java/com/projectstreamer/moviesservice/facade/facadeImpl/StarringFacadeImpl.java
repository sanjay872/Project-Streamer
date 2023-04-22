package com.projectstreamer.moviesservice.facade.facadeImpl;

import com.projectstreamer.moviesservice.datamapper.StarringDataMapper;
import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.StarringDto;
import com.projectstreamer.moviesservice.entity.Starring;
import com.projectstreamer.moviesservice.facade.StarringFacade;
import com.projectstreamer.moviesservice.service.StarringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StarringFacadeImpl implements StarringFacade {

    @Autowired
    private StarringService service;

    @Autowired
    private StarringDataMapper dataMapper;

    @Override
    public Long createStarring(StarringDto starringDto) {
        return service.createStarring(dataMapper.starringDtoToStarring(starringDto));
    }

    @Override
    public PageableDto getAllStarring(int pageNo, int pageSize) {
        Page<Starring> pagedStarring=service.getAllStarring(pageNo,pageSize);
        List<StarringDto> starringDto=pagedStarring.getContent().stream().map(dataMapper::starringToStarringDto).collect(Collectors.toList());
        return new PageableDto<>(starringDto,pagedStarring.getTotalElements());
    }

    @Override
    public void updateStarring(StarringDto starringDto) {
        service.updateStarring(dataMapper.starringDtoToStarring(starringDto));
    }

    @Override
    public void deleteStarring(Long id) {
        service.deleteStarring(id);
    }
}
