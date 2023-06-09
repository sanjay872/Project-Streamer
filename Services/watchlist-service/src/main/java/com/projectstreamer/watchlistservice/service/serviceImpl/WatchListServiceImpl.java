package com.projectstreamer.watchlistservice.service.serviceImpl;

import com.projectstreamer.watchlistservice.entity.Item;
import com.projectstreamer.watchlistservice.entity.WatchList;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.watchlistservice.repository.WatchListRepository;
import com.projectstreamer.watchlistservice.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WatchListServiceImpl implements WatchListService {

    @Autowired
    private WatchListRepository repository;

    @Override
    public Long createWatchList(WatchList watchList) {
       return repository.save(watchList).getId();
    }

    @Override
    public WatchList getWatchListById(Long id) {
        Optional<WatchList> existWatchList=repository.findById(id);
        if(existWatchList.isPresent())
            return existWatchList.get();
        else
            throw new CustomNotFoundException("WatchList not found");
    }

    @Override
    public void updateWatchListName(Long id, String newName) {
        Optional<WatchList> existWatchList=repository.findById(id);
        if(existWatchList.isPresent())
        {
            WatchList watchList=existWatchList.get();
            watchList.setName(newName);
            repository.save(watchList);
        }
        else
            throw new CustomNotFoundException("WatchList not found");
    }

    @Override
    public void deleteWatchList(Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("WatchList not found");
    }

    @Override
    public Set<Item> getWatchListItems(Long id) {
        Optional<WatchList> watchList=repository.findById(id);
        if(watchList.isPresent()){
                return watchList.get().getItems();
        }
        return new HashSet<>();
    }

    @Override
    public void updateWatchListItems(Long id, Item item) {
        Optional<WatchList> watchList=repository.findById(id);
        if(watchList.isPresent()){
            WatchList existWatchList=watchList.get();
            Set<Item> watchListItems=existWatchList.getItems();
            watchListItems.add(item);
            existWatchList.setItems(watchListItems);
            repository.save(existWatchList);
        }
        else
            throw new CustomNotFoundException("WatchList not found");
    }
}
