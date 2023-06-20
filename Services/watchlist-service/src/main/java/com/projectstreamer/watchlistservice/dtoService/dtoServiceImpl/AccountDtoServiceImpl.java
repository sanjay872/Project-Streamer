package com.projectstreamer.watchlistservice.dtoService.dtoServiceImpl;

import com.projectstreamer.watchlistservice.dataMapper.AccountDataMapper;
import com.projectstreamer.watchlistservice.dto.AccountDto;
import com.projectstreamer.watchlistservice.dtoService.AccountDtoService;
import com.projectstreamer.watchlistservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoServiceImpl implements AccountDtoService {

    @Autowired
    private AccountDataMapper dataMapper;

    @Autowired
    private AccountService service;

    @Override
    public Long createAccount(AccountDto accountDto) {
        return service.createAccount(dataMapper.accountDtoToAccount(accountDto));
    }

    @Override
    public AccountDto getAccountByUserId(String userId) {
        return dataMapper.accountToAccountDto(service.getAccountByUserId(userId));
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
        service.updateAccount(dataMapper.accountDtoToAccount(accountDto));
    }

    @Override
    public void deleteAccountByUserId(String userId) {
        service.deleteAccountByUserId(userId);
    }
}
