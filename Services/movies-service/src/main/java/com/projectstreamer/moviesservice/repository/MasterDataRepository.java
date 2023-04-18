package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterData,Long> {
}
