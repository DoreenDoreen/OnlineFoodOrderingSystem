package com.laioffer.onlineOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity  // 创建security框架在项目中运行需要的class
public class SecurityConfig extends WebSecurityConfigurerAdapter {  //


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 先判断登录
        http.csrf().disable()
                .formLogin()    // 通过表单方式来进行登录
                .failureForwardUrl("/login?error=true");

        http.authorizeRequests()
                .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
                //  括号里是 配置/设置需要检验权限的 end-point， * 正则表达式 表示数字
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {   // 这里是做配置
        // 再执行 这个fn
        auth.jdbcAuthentication()
                .dataSource(dataSource)  // 链接数据库
                .usersByUsernameQuery("SELECT email, password, enabled FROM customers WHERE email=?")   // 通过SQL语句来拿到用户的email, enable是用户是否有效活着
                .authoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email=?");  // 通过SQL语句来拿到用户的

    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {  // 没有做 override encoder bean 把用户发来的密码encode,后端保存的， 没有做encode password
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
