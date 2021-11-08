package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.CartDao;
import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {  // 获取当前用户的购物车

    @Autowired
    private CustomerService customerService;  // 注入CustomerService

    @Autowired
    private CartDao cartDao;  // 为了拿到用户对象

    // 测试的话压要先login 再getCart
    public Cart getCart() {  // 不用参数。因为是从 SecurityContextHolder 里拿到的验证股哟的getAuthentication()
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username); // 通过当前用户的email找到这个customer

        // 计算购物车的总价 totalPrice
        if (customer != null) {
            Cart cart = customer.getCart();
            double totalPrice = 0;
            for (OrderItem item : cart.getOrderItemList()) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            return cart;
        }
        return new Cart();
    }

    public void cleanCart() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        if (customer != null)
            cartDao.removeAllCartItems(customer.getCart());
    }



}

