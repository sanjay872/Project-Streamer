package com.projectstreamer.watchlistservice.dataMapper;

import com.projectstreamer.watchlistservice.dto.AccountDto;
import com.projectstreamer.watchlistservice.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WatchListDataMapper.class})
public interface AccountDataMapper {

    Account accountDtoToAccount(AccountDto accountDto);
    AccountDto accountToAccountDto(Account account);

}
