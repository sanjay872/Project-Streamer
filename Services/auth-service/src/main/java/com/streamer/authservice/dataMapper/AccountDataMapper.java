package com.streamer.authservice.dataMapper;

import com.streamer.authservice.dto.AccountDto;
import com.streamer.authservice.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {RoleDataMapper.class})
public interface AccountDataMapper {
    Account accountDtoToAccount(AccountDto accountDto);
    AccountDto accountToAccountDto(Account account);
}
