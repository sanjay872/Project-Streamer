package com.projectstreamer.watchlistservice.dtoService.dtoServiceImpl;

import com.projectstreamer.watchlistservice.dataMapper.ItemCategoryDataMapper;
import com.projectstreamer.watchlistservice.dto.ItemCategoryDto;
import com.projectstreamer.watchlistservice.dtoService.ItemCategoryDtoService;
import com.projectstreamer.watchlistservice.entity.ItemCategory;
import com.projectstreamer.watchlistservice.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemCategoryDtoServiceImpl implements ItemCategoryDtoService {

    @Autowired
    private ItemCategoryDataMapper dataMapper;

    @Autowired
    private ItemCategoryService service;

    @Override
    public Long createItemCategory(ItemCategoryDto itemCategoryDto) {
        return service.createItemCategory(dataMapper.ItemCategoryDtoToItemCategory(itemCategoryDto));
    }

    @Override
    public List<ItemCategoryDto> getAllItemCategory() {
        List<ItemCategory> itemCategories=service.getAllItemCategory();
        return itemCategories.stream().map(dataMapper::ItemCategoryToItemCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void updateItemCategory(ItemCategoryDto itemCategoryDto) {
        service.updateItemCategory(dataMapper.ItemCategoryDtoToItemCategory(itemCategoryDto));
    }

    @Override
    public void deleteItemCategory(Long id) {
        service.deleteItemCategory(id);
    }
}
