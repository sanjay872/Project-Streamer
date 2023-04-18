package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.SubData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDataRepository extends JpaRepository<SubData,Long> {
}
