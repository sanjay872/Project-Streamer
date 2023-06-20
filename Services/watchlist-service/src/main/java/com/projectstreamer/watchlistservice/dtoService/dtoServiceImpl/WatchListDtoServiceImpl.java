package com.projectstreamer.watchlistservice.dtoService.dtoServiceImpl;

import com.projectstreamer.watchlistservice.dataMapper.WatchListDataMapper;
import com.projectstreamer.watchlistservice.dto.WatchListDto;
import com.projectstreamer.watchlistservice.dtoService.WatchListDtoService;
import com.projectstreamer.watchlistservice.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WatchListDtoServiceImpl implements WatchListDtoService {

    @Autowired
    private WatchListDataMapper dataMapper;

    @Autowired
    private WatchListService service;

    @Override
    public Long createWatchList(WatchListDto watchListDto) {
        return service.createWatchList(dataMapper.watchListDtoToWatchList(watchListDto));
    }

    @Override
    public WatchListDto getWatchListById(Long id) {
        return dataMapper.watchListToWatchListDto(service.getWatchListById(id));
    }

    @Override
    public void updateWatchListName(Long id, String newName) {
        service.updateWatchListName(id,newName);
    }

    @Override
    public void deleteWatchList(Long id) {
        service.deleteWatchList(id);
    }
}
