package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Starring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarringRepository extends JpaRepository<Starring,Long> {

}
