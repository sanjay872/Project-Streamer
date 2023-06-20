package com.projectstreamer.watchlistservice.dtoService;

import com.projectstreamer.watchlistservice.dto.ItemDto;

public interface ItemDtoService {
    Long createItem(ItemDto itemDto);

    void updateItem(ItemDto itemDto);

    void deleteItem(Long id);
}
