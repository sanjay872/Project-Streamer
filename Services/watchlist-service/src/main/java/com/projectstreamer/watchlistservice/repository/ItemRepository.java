package com.projectstreamer.watchlistservice.repository;

import com.projectstreamer.watchlistservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    boolean existsByDataId(Long dataId);

    void deleteByDataId(Long id);
}
