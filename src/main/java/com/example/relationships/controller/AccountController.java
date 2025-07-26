package com.example.relationships.controller;

import com.example.relationships.model.Account;
import com.example.relationships.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping
    private List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @DeleteMapping("/{id}")
    private String deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return "SUCCESS";
    }

    @PutMapping
    private Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
