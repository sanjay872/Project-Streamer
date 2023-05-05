package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.SubMasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubMasterDataRepository extends JpaRepository<SubMasterData,Long> {
    Optional<SubMasterData> findByCode(String code);

    @Query("select s from SubMasterData s where s.masterDataCode = ?1")
    List<SubMasterData> findAllByMasterDataCode(String masterDataCode);

    Optional<SubMasterData> getByCodeAndIdNot(String code, Long id);
}
