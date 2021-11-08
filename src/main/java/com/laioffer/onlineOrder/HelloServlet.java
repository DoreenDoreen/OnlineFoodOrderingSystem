
package com.laioffer.onlineOrder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

@WebServlet(name = "helloServlet", value = "/hello-servlet") // value定义了url里的resource path 资源路径
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {//        response.setContentType("application/json");  // 后端处理完代码返回给前端的format 是JSON

        JSONObject customer = new JSONObject();
        customer.put("email", "123@gmail.com");
        response.getWriter().println(customer);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = new JSONObject(IOUtils.toString(request.getReader())); //
        String email = json.getString("email");
        String firstName = json.getString("first_name");
        int age = json.getInt("age");  // 把拿到的 Integer 转化成 int

        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }


    public void destroy() {
    }
}