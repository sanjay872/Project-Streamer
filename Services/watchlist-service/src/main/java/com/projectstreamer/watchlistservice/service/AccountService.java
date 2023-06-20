package com.projectstreamer.watchlistservice.service;

import com.projectstreamer.watchlistservice.entity.Account;

public interface AccountService {

    Long createAccount(Account account);

    Account getAccountByUserId(String userId);

    void updateAccount(Account account);

    void deleteAccountByUserId(String userId);
}
