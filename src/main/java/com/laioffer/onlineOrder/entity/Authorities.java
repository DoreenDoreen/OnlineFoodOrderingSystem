package com.laioffer.onlineOrder.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {  // Authorities这个class 是用来分配用户的权限的，根据用户具体的email来设置不同的权限

    private static final long serialVersionUID = 8734140534986494039L; // UID 是随机生成的，是为了区分每个版本的不一样
    // 在memory里的格式序列化的数据，存在磁盘上，将来拿到数据后，在反序列化成

    @Id
    private String email;

    private String authorities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }



}
