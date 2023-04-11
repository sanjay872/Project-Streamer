package com.streamer.authservice.service;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.entity.Account;
import org.springframework.data.domain.Page;

public interface AccountService {
    Account registerAccount(Account request);

    Account authenticateAccount(Account request);

    Account getAccountByUserId(String userId);

    void updateEmail(Account account);

    void deleteAccount(String userId);

    Page<Account> getAllAccount(int pageNo, int pageSize, String sortBy);

    void updatePassword(Account account);

    Account createAdmin(Account adminAccount);
}
