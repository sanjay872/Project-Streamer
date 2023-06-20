package com.projectstreamer.watchlistservice.dtoService.dtoServiceImpl;

import com.projectstreamer.watchlistservice.dataMapper.ItemDataMapper;
import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.dtoService.ItemDtoService;
import com.projectstreamer.watchlistservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoServiceImpl implements ItemDtoService {

    @Autowired
    private ItemDataMapper dataMapper;

    @Autowired
    private ItemService service;

    @Override
    public Long createItem(ItemDto itemDto) {
        return service.createItem(dataMapper.ItemDtoToItem(itemDto));
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        service.updateItem(dataMapper.ItemDtoToItem(itemDto));
    }

    @Override
    public void deleteItem(Long id) {
        service.deleteItem(id);
    }
}
