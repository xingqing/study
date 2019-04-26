package com.codefun.controller;

import com.codefun.service.TestService;
import com.codefun.util.SpringContextUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/8.
 */
public class TestServlet extends HttpServlet {

    public TestServlet(){
        System.out.println("构造调用");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init调用");
        super.init(config);
    }

    @Override
    public void destroy() {
        System.out.println("destroy调用");
        super.destroy();
    }

    @PostConstruct
    private void myInit(){
        System.out.println("PostConstruct调用");
    }
    @PreDestroy
    private void mydestroy(){
        System.out.println("PreDestroy调用");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestService  service = (TestService)SpringContextUtil.getBean("testService");
       // service = (TestService)WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext()).getBean("testService");
        System.out.println(new TestService().todo());

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
