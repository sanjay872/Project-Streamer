package com.projectstreamer.watchlistservice.service.serviceImpl;

import com.projectstreamer.watchlistservice.entity.Account;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomException;
import com.projectstreamer.watchlistservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.watchlistservice.repository.AccountRepository;
import com.projectstreamer.watchlistservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Long createAccount(Account account) {
        if(repository.existsByUserId(account.getUserId())){
            throw new CustomException("Account already exist");
        }
        return repository.save(account).getId();
    }

    @Override
    public Account getAccountByUserId(String userId) {
        Optional<Account> account=repository.findByUserId(userId);
        if(account.isPresent()){
            return account.get();
        }
        throw new CustomNotFoundException("Account not found!");
    }

    @Override
    public void updateAccount(Account account) {
        if(repository.existsByUserId(account.getUserId())){
            repository.save(account);
        }
        throw new CustomNotFoundException("Account not found");
    }

    @Override
    public void deleteAccountByUserId(String userId) {
        if(repository.existsByUserId(userId)){
            repository.deleteByUserId(userId);
        }
        throw new CustomNotFoundException("Account not found");
    }
}
