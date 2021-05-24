package com.example.freefire.controller;

import com.example.freefire.dto.ItemDTO;
import com.example.freefire.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {
    final private IItemService iItemService;

    @Autowired
    public ItemController(IItemService iItemService) {
        this.iItemService = iItemService;
    }
    @RequestMapping("admin/item/index")
    public String index(Model model){
        model.addAttribute("items",iItemService.findAll());
        return "item/index";
    }
    @RequestMapping("/admin/item/add")
    public String add(Model model){
        ItemDTO itemDTO= new ItemDTO();
        model.addAttribute("itemDTO",itemDTO);
        return "item/add";
    }
    @RequestMapping(value = "/admin/item/add",method = RequestMethod.POST)
    public String add(Model model,ItemDTO itemDTO){
        iItemService.save(itemDTO);
        return "redirect:/admin/item/index";
    }
    @RequestMapping(value = "admin/item/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        ItemDTO itemDTO= iItemService.getItemDTOById(id);
        model.addAttribute("itemDTO",itemDTO);
        return "item/add";
    }
    @RequestMapping(value = "admin/item/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        iItemService.deleteById(id);
        return "redirect:/admin/item/index";
    }
}
