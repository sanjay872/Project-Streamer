package com.streamer.authservice.service.serviceImpl;

import com.streamer.authservice.entity.Account;
import com.streamer.authservice.entity.Role;
import com.streamer.authservice.exception.exceptions.CustomException;
import com.streamer.authservice.exception.exceptions.CustomNotFoundException;
import com.streamer.authservice.repository.AccountRepository;
import com.streamer.authservice.repository.RoleRepository;
import com.streamer.authservice.service.AccountService;
import com.streamer.authservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Utils utils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Account registerAccount(Account request) {
        Account account;
        if(accountRepository.findByEmail(request.getEmail()).isEmpty())
            account=this.createAccount(request);
        else
            throw new CustomException("account already exist found");
        return account;
    }

    @Override
    public Account authenticateAccount(Account request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );
        return accountRepository.findByEmail(request.getEmail()).get();
    }

    @Override
    public Account getAccountByUserId(String userId) {
        Optional<Account> account=accountRepository.findByUserId(userId);
        if(account.isPresent())
            return accountRepository.findByUserId(userId).get();
        else
            throw new CustomNotFoundException("Account not found");
    }

    @Override
    public void updateEmail(Account account) {
        Optional<Account> existAccount=accountRepository.findByEmail(account.getEmail());
        if(existAccount.isPresent())
        {
            if(accountRepository.findByEmail(account.getEmail()).isPresent())
            {
                throw new CustomException("The updating email already exist");
            }
            else {
                Account dataAlteredAccount=existAccount.get();
                dataAlteredAccount.setEmail(account.getEmail());
                accountRepository.save(dataAlteredAccount);
            }
        }
        else
            throw new CustomNotFoundException("Account not found");
    }

    @Override
    public void deleteAccount(String userId) {
        Optional<Account> existAccount=accountRepository.findByUserId(userId);
        if(existAccount.isPresent())
                accountRepository.deleteByUserId(userId);
        else
            throw new CustomNotFoundException("Account not found");
    }

    @Override
    public Page<Account> getAllAccount(int pageNo, int pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        return accountRepository.findAll(pageable);
    }

    @Override
    public void updatePassword(Account account) {
        Optional<Account> existAccount=accountRepository.findByEmail(account.getEmail());
        if(existAccount.isPresent())
        {
                Account dataAlteredAccount=existAccount.get();
                dataAlteredAccount.setPassword(passwordEncoder.encode(account.getPassword()));
                accountRepository.save(dataAlteredAccount);
        }
        else
            throw new CustomNotFoundException("Account not found");
    }

    @Override
    public Account createAdmin(Account adminAccount) {
        if(accountRepository.findByEmail(adminAccount.getEmail()).isPresent()){
            throw new CustomException("Already exist");
        }
        else{
            Account newAccount= new Account();
            newAccount.setEmail(adminAccount.getEmail());
            newAccount.setPassword(passwordEncoder.encode(adminAccount.getPassword()));
            newAccount.setUserId(utils.generateId(8));
            newAccount.setRoles(getRoles("ROLE_ADMIN"));
            return accountRepository.save(newAccount);
        }
    }

    private Account createAccount(Account request){
        if(accountRepository.findByEmail(request.getEmail()).isPresent()){
            throw new CustomException("Already exist");
        }
        else{
            Account newAccount= new Account();
            newAccount.setEmail(request.getEmail());
            newAccount.setPassword(passwordEncoder.encode(request.getPassword()));
            newAccount.setUserId(utils.generateId(8));
            newAccount.setRoles(getRoles("ROLE_USER"));
            return accountRepository.save(newAccount);
        }
    }

    private Set<Role> getRoles(String roleName){
        Optional<Role> role=roleRepository.findByRole(roleName);
        if(role.isPresent()){
            Set<Role> roles=new HashSet<>();
            roles.add(role.get());
            return roles;
        }
        else
            throw new CustomNotFoundException("Default Role not found");
    }
}
