package com.example.freefire.service;

import com.example.freefire.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account save(Account account);
}
