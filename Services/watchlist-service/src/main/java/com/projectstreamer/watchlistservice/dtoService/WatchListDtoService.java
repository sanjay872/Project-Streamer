package com.projectstreamer.watchlistservice.dtoService;

import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.dto.WatchListDto;

import java.util.Set;

public interface WatchListDtoService {
    Long createWatchList(WatchListDto watchListDto);

    WatchListDto getWatchListById(Long id);

    void updateWatchListName(Long id, String newName);

    void deleteWatchList(Long id);

    Set<ItemDto> getWatchListItems(Long id);

    void updateWatchListItems(Long id, ItemDto itemDto);
}
