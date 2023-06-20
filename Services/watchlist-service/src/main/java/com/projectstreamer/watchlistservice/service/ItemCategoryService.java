package com.projectstreamer.watchlistservice.service;

import com.projectstreamer.watchlistservice.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    Long createItemCategory(ItemCategory itemCategory);

    List<ItemCategory> getAllItemCategory();

    void updateItemCategory(ItemCategory itemCategory);

    void deleteItemCategory(Long id);
}
