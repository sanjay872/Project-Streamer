package com.projectstreamer.watchlistservice.service;

import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.entity.Item;
import com.projectstreamer.watchlistservice.entity.WatchList;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface WatchListService {
    Long createWatchList(WatchList watchList);

    WatchList getWatchListById(Long id);

    void updateWatchListName(Long id, String newName);

    void deleteWatchList(Long id);

    Set<Item> getWatchListItems(Long id);

    void updateWatchListItems(Long id, Item item);
}
