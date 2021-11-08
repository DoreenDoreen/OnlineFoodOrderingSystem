package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ItemOrderController {  // 要测试这个

    @Autowired
    private ItemOrderService itemOrderService;  // 注入 ItemOrderService

    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)   // 去购物车里添加东西 一般都是设置成 POST 请求
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {  // @PathVariable("menuId") will match part of path which was defined in @RequestMapping(value = "/order/{menuId}"
        // 添加一个order 到购物车里
        itemOrderService.saveOrderItem(menuId);
    }
}

