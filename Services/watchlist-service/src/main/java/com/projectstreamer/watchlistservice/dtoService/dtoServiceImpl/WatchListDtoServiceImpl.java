package com.projectstreamer.watchlistservice.dtoService.dtoServiceImpl;

import com.projectstreamer.watchlistservice.dataMapper.ItemDataMapper;
import com.projectstreamer.watchlistservice.dataMapper.WatchListDataMapper;
import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.dto.PageableDto;
import com.projectstreamer.watchlistservice.dto.WatchListDto;
import com.projectstreamer.watchlistservice.dtoService.WatchListDtoService;
import com.projectstreamer.watchlistservice.entity.Item;
import com.projectstreamer.watchlistservice.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class WatchListDtoServiceImpl implements WatchListDtoService {

    @Autowired
    private WatchListDataMapper dataMapper;

    @Autowired
    private ItemDataMapper itemDataMapper;

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

    @Override
    public Set<ItemDto> getWatchListItems(Long id) {
        Set<Item> items=service.getWatchListItems(id);
        return items.stream().map(itemDataMapper::ItemToItemDto).collect(Collectors.toSet());
    }

    @Override
    public void updateWatchListItems(Long id, ItemDto itemDto) {
        service.updateWatchListItems(id,itemDataMapper.ItemDtoToItem(itemDto));
    }
}
