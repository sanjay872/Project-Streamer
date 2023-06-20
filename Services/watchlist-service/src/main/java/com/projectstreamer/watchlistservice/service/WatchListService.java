package com.projectstreamer.watchlistservice.service;

import com.projectstreamer.watchlistservice.entity.WatchList;

public interface WatchListService {
    Long createWatchList(WatchList watchList);

    WatchList getWatchListById(Long id);

    void updateWatchListName(Long id, String newName);

    void deleteWatchList(Long id);
}
