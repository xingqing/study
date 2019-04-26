package com.codefun.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;


public class SpringContextUtil implements ApplicationContextAware {

    private  static  ApplicationContext context;

    private SpringContextUtil() {
        System.out.println("SpringContextUtil构造被调用");
    }


    @PostConstruct
    private void init(){
        System.out.println("SpringContextUtil postConstruct");
    }


    public static  <T> T getBean(String name, Class<T> type)  {
        T t = context.getBean(name, type);
        if (t != null)
            return t;
        return context.getBean(type);
    }

    @SuppressWarnings("unchecked")
    public static  <T> T getBean(String name)  {
        return (T) context.getBean(name);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        if (context == null) {
            synchronized (SpringContextUtil.class) {
                if (context == null) {
                    context = applicationContext;
                }
            }
        }
    }
}