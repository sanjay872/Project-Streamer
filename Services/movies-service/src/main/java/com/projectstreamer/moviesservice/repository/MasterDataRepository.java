package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterData,Long> {
    Optional<MasterData> findByCode(String code);

    Optional<MasterData> getCodeAndNotId(String code, Long id);
}
