// HttpServlet.java
package org.didnelpsun.boot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// WebServlet表示当前为WebServlet
// 用于标注在一个继承了HttpServlet类之上，属于类级别的注解
@WebServlet(name = "TestServlet", value = "/testServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
