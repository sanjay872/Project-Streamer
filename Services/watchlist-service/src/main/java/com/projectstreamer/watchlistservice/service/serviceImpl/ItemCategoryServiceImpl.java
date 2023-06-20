package com.projectstreamer.watchlistservice.service.serviceImpl;

import com.projectstreamer.watchlistservice.entity.ItemCategory;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.watchlistservice.repository.ItemCategoryRepository;
import com.projectstreamer.watchlistservice.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryRepository repository;

    @Override
    public Long createItemCategory(ItemCategory itemCategory) {
            return repository.save(itemCategory).getId();
    }

    @Override
    public List<ItemCategory> getAllItemCategory() {
        return repository.findAll();
    }

    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        if(repository.existsById(itemCategory.getId()))
            repository.save(itemCategory);
        else
            throw new CustomNotFoundException("Item Category not found");
    }

    @Override
    public void deleteItemCategory(Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Item Category not found");
    }
}
