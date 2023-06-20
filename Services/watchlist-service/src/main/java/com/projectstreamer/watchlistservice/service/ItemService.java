package com.projectstreamer.watchlistservice.service;

import com.projectstreamer.watchlistservice.entity.Item;

public interface ItemService {
    Long createItem(Item item);

    void updateItem(Item item);

    void deleteItem(Long id);
}
