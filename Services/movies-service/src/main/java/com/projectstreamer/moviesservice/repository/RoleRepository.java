package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "SELECT r FROM Role r WHERE r.movie.id = ?1")
    Page<Role> findRolesByMovieId(Long id, Pageable of);
}
