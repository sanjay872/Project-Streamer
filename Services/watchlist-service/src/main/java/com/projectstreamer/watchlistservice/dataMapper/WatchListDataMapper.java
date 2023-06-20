package com.projectstreamer.watchlistservice.dataMapper;

import com.projectstreamer.watchlistservice.dto.WatchListDto;
import com.projectstreamer.watchlistservice.entity.Account;
import com.projectstreamer.watchlistservice.entity.WatchList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ItemDataMapper.class})
public interface WatchListDataMapper {

    @Named("buildAccountFromId")
    static Account convertToAccount(Long id){
        return Account.builder().id(id).build();
    }

    @Named("getIdFromAccount")
    static Long accountToAccountDto(Account account){
        return account.getId();
    }

    @Mapping(source = "account", target = "account", qualifiedByName = "buildAccountFromId")
    WatchList watchListDtoToWatchList(WatchListDto watchListDto);
    @Mapping(source = "account", target = "account", qualifiedByName = "getIdFromAccount")
    WatchListDto watchListToWatchListDto(WatchList watchList);
}
