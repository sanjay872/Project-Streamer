package com.streamer.authservice.dtoService.dtoServiceImpl;

import com.streamer.authservice.dataMapper.AccountDataMapper;
import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.dto.AuthDto;
import com.streamer.authservice.dto.AuthResponseDto;
import com.streamer.authservice.dto.PageableDto;
import com.streamer.authservice.entity.Account;
import com.streamer.authservice.dtoService.AccountDtoService;
import com.streamer.authservice.security.JwtService;
import com.streamer.authservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountDtoServiceImpl implements AccountDtoService {

    @Autowired
    private AccountService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountDataMapper dataMapper;

    @Override
    public AuthResponseDto registerAccount(AuthDto auth) {
        Account account=service.registerAccount(Account.builder().email(auth.getEmail()).password(auth.getPassword()).build());
        String generatedToken=jwtService.generateToken(account);
        return AuthResponseDto.builder().userId(account.getUserId()).token(generatedToken).build();
    }

    @Override
    public AuthResponseDto authenticateAccount(AuthDto auth) {
        Account account=service.authenticateAccount(Account.builder().email(auth.getEmail()).password(auth.getPassword()).build());
        String generatedToken=jwtService.generateToken(account);
        return  AuthResponseDto.builder().userId(account.getUserId()).token(generatedToken).build();
    }

    @Override
    public AccountDto getAccount(String userId) {
        return dataMapper.accountToAccountDto(service.getAccountByUserId(userId));
    }

    @Override
    public void updateEmail(AccountDto request) {
        service.updateEmail(dataMapper.accountDtoToAccount(request));
    }

    @Override
    public void deleteAccount(String userId) {
        service.deleteAccount(userId);
    }

    @Override
    public PageableDto getAllAccount(int pageNo, int pageSize, String sortBy) {
        Page<Account> pagedAccounts=service.getAllAccount(pageNo,pageSize,sortBy);
        List<AccountDto> accounts=pagedAccounts.getContent().stream().map(account -> dataMapper.accountToAccountDto(account)).collect(Collectors.toList());
        return new PageableDto<>(accounts,pagedAccounts.getTotalElements());
    }

    @Override
    public void updatePassword(AccountDto account) {
        service.updatePassword(dataMapper.accountDtoToAccount(account));
    }

    @Override
    public AuthResponseDto createAdmin(AccountDto adminAccount) {
        Account account=service.createAdmin(dataMapper.accountDtoToAccount(adminAccount));
        String generatedToken=jwtService.generateToken(account);
        return AuthResponseDto.builder().userId(account.getUserId()).token(generatedToken).build();
    }
}
