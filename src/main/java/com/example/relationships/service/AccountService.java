package com.example.relationships.service;

import com.example.relationships.model.Account;
import com.example.relationships.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
