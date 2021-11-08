package com.laioffer.onlineOrder.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;
              // cascade 级联操作可以自动完成添加/删除/更新 cart 记录，这样我们不需要在Dao layer去保存cart记录，hibernate会默认去 Cart 表里面添加cart记录，再关联到Customer table上作为一个FK。
    @OneToOne(cascade = CascadeType.ALL)  // CascadeType.ALL 级联操作 -> 表示包含了所有的操作：PERSIST(做insert操作)，MERGE，REMOVE(做delete操作)，REFRESH，DETACH
    @JoinColumn(unique = true)   // @JoinColumn(unique = true) 只用在一对一的情况下，保证customer 里cart 这个 FK 永远都是唯一的， unique的，避免了重复的情况，确保了每一个用户使用的cart都是unique的，不重复的
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return  enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
