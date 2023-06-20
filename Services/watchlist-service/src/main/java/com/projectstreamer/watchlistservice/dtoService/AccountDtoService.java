package com.projectstreamer.watchlistservice.dtoService;

import com.projectstreamer.watchlistservice.dto.AccountDto;

public interface AccountDtoService {
    Long createAccount(AccountDto accountDto);

    AccountDto getAccountByUserId(String userId);

    void updateAccount(AccountDto accountDto);

    void deleteAccountByUserId(String userId);
}
