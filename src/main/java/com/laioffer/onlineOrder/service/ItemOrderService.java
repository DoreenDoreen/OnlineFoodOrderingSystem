package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.ItemOrderDao;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {  // 要测试这个ItemOrderService() 必须要先跑 login，再跑 addItem
    // 一般不会直接inject Dao 的class, 都是service之间互相调用, 因为如果直接引入Dao class 后期不好维护
    @Autowired
    private MenuInfoService menuInfoService;   // menuInfoService 是 MenuInfoService里的方法

    @Autowired
    private CustomerService customerService;  // inject CustomerService

    @Autowired
    private ItemOrderDao itemOrderDao;

    public void saveOrderItem(int menuId) {  // menuId是 menuItem 的 主键
         OrderItem orderItem = new OrderItem();
         MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        itemOrderDao.save(orderItem);
    }

//    public void saveItem(int menuId) {  // 老师的代码这里的的函数名字不一样“saveOrderItem”
//        final OrderItem orderItem = new OrderItem();
//        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String username = loggedInUser.getName();
//        Customer customer = customerService.getCustomer(username);
//
//        orderItem.setMenuItem(menuItem);
//        orderItem.setCart(customer.getCart());
//        orderItem.setQuantity(1);
//        orderItem.setPrice(menuItem.getPrice());
//        itemOrderDao.save(orderItem);
//    }
}
