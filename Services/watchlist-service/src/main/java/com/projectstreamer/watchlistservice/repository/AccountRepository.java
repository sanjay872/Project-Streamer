package com.projectstreamer.watchlistservice.repository;

import com.projectstreamer.watchlistservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    boolean existsByUserId(String userId);

    Optional<Account> findByUserId(String userId);

    void deleteByUserId(String userId);
}
