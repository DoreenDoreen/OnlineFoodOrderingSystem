package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.dao.MenuInfoDao;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.Restaurant;
import com.laioffer.onlineOrder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuInfoController {  // 该函数主要是用来 load 两部分数据：restaurants 和 具体译者restaurant的MenuItem list

    @Autowired
    private MenuInfoService menuInfoService;


    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody   // 会自动转化成JSON format
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();

    }

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenuItems(@PathVariable("restaurantId") int restaurantId) {  //这里的函数命名 getMenuItems 与课件上不一样
        return menuInfoService.getAllMenuItem(restaurantId);

    }



}
