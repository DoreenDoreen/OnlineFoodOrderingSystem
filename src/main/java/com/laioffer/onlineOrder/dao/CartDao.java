package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void removeCartItem(int orderItemId) {  // 只删掉一个记录 orderItemId 和课件上的名字不一样
        // 通过cartItemId找到了OrderItem orderItemId，
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem orderItem = session.get(OrderItem.class, orderItemId);
            Cart cart = orderItem.getCart();
            cart.getOrderItemList().remove(orderItem);

            session.beginTransaction();
            session.delete(orderItem);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void removeAllCartItems(Cart cart) {  // 记录全部删掉
        for (OrderItem item : cart.getOrderItemList()) {
            removeCartItem(item.getId());
        }
    }
}
