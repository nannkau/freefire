package com.example.freefire.controller;

import com.example.freefire.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

    final private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @RequestMapping("/admin/account.html")
    private String index(Model model){
        model.addAttribute("accounts",accountService.findAll());
        return "account";
    }

}
