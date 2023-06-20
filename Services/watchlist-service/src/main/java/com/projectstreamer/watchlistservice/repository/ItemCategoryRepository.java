package com.projectstreamer.watchlistservice.repository;

import com.projectstreamer.watchlistservice.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
}
