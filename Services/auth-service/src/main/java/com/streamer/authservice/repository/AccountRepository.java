package com.streamer.authservice.repository;

import com.streamer.authservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findByUserId(String id);

    void deleteByUserId(String userId);
}
