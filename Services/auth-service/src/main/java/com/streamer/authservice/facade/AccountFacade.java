package com.streamer.authservice.facade;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.dto.AuthDto;
import com.streamer.authservice.dto.AuthResponseDto;
import com.streamer.authservice.dto.PageableDto;

public interface AccountFacade {
    AuthResponseDto registerAccount(AuthDto auth);

    AuthResponseDto authenticateAccount(AuthDto auth);

    AccountDto getAccount(String userId);

    void updateEmail(AccountDto account);

    void deleteAccount(String userId);

    PageableDto getAllAccount(int pageNo, int pageSize, String sortBy);

    void updatePassword(AccountDto account);

    AuthResponseDto createAdmin(AccountDto adminAccount);
}
