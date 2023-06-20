package com.projectstreamer.watchlistservice.service.serviceImpl;

import com.projectstreamer.watchlistservice.entity.WatchList;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.watchlistservice.repository.WatchListRepository;
import com.projectstreamer.watchlistservice.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
