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

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        /* One to One Mapping
        if (account.getPrimaryAddress() != null) {
            account.getPrimaryAddress().setAccount(account); // 👈 back-reference set
        }
        */

        if (!account.getAddresses().isEmpty()) {
            account.getAddresses().forEach(address -> address.setAccount(account));
        }

        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        /* One to One Mapping
        if (account.getPrimaryAddress() != null) {
            account.getPrimaryAddress().setAccount(account); // 👈 back-reference set
        }
        */

        if (!account.getAddresses().isEmpty()) {
            account.getAddresses().forEach(address -> address.setAccount(account));
        }

        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
