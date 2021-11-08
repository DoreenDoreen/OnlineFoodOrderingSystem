package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;  // 注入


    @RequestMapping(value = "/cart", method = RequestMethod.GET) // value = "/cart" is to define the API
    @ResponseBody
    public Cart getCart(){   // 因为 从前端的角度来看，前端其实不知道 cart id 信息，因为 cart is 是当用户注册的时候，hibernate 去默认分配的一个值，所以前端没办法知道这个信息，
                             // solution 是我们可以通过找 先拿到一个用户对象，再拿到该用户的email，从而就可以拿到对应的 cart，
                             // 所以这里我们并没有传进来 cart id
//        return new Cart();
        return cartService.getCart();

    }
}
