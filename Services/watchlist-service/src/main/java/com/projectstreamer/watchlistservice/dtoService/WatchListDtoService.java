package com.projectstreamer.watchlistservice.dtoService;

import com.projectstreamer.watchlistservice.dto.WatchListDto;

public interface WatchListDtoService {
    Long createWatchList(WatchListDto watchListDto);

    WatchListDto getWatchListById(Long id);

    void updateWatchListName(Long id, String newName);

    void deleteWatchList(Long id);
}
