package com.example.freefire.controller;

import com.example.freefire.entity.Account;
import com.example.freefire.service.IAccountService;
import com.example.freefire.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    final private IItemService iItemService;
    final private IAccountService accountService;
    @Autowired
    public HomeController(IItemService iItemService, IAccountService accountService) {
        this.iItemService = iItemService;
        this.accountService = accountService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("items",iItemService.findEnable());
        model.addAttribute("account",new Account());
        return "home";
    }
    @RequestMapping(value = "/account/add",method = RequestMethod.POST )
    public String add(Account account){
        accountService.save(account);
        return "redirect:/";
    }
}
