package com.example.relationships.controller;

import com.example.relationships.model.Account;
import com.example.relationships.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @CachePut("accounts")
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping
    @Cacheable("accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @DeleteMapping("/{id}")
    @CacheEvict("accounts")
    public String deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return "SUCCESS";
    }

    @PutMapping
    @CachePut("accounts")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
