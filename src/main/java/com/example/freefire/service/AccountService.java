package com.example.freefire.service;

import com.example.freefire.entity.Account;
import com.example.freefire.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService{
    final private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
