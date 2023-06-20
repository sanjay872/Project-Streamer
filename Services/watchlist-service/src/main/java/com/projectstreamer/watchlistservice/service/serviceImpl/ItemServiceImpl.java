package com.projectstreamer.watchlistservice.service.serviceImpl;

import com.projectstreamer.watchlistservice.entity.Item;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomException;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.watchlistservice.repository.ItemRepository;
import com.projectstreamer.watchlistservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Long createItem(Item item) {
        if(repository.existsByDataId(item.getDataId()))
        {
            throw  new CustomException("Item already exist");
        }
        return repository.save(item).getDataId();
    }

    @Override
    public void updateItem(Item item) {
        if(repository.existsByDataId(item.getDataId()))
            repository.save(item);
        throw  new CustomNotFoundException("Item not found");
    }

    @Override
    public void deleteItem(Long id) {
        if(repository.existsByDataId(id))
            repository.deleteByDataId(id);
        throw  new CustomNotFoundException("Item not found");
    }
}
