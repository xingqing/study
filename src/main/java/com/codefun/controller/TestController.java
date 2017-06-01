package com.codefun.controller;

import com.codefun.pojo.TestVo;
import com.codefun.service.TestService;
import com.codefun.util.JacksonMapper;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/8.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Resource(name = "testService")
    private TestService  service;

    @RequestMapping(value="/todo.do")
    public @ResponseBody   TestVo todo(){

        System.out.println("Controller Handler÷¥––");
        TestVo vo = new TestVo();
        vo.setName(service.todo());
        vo.setId(1L);
        StringWriter sw = new StringWriter();
        try {
            JacksonMapper.getMapper().writeValue(sw,vo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vo;
    }

    public static void main(String[] args) {
        TestVo vo = new TestVo();
        vo.setName("2222");
        vo.setId(1L);
        vo.setTime(new Date());
        StringWriter sw = new StringWriter();

        ObjectMapper mapper = JacksonMapper.getMapper();

        try {
            mapper.writeValue(sw,vo);
           vo =  mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true).readValue("{id:12,name:\"aa\"}",TestVo.class);
            System.out.println(vo);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(sw.toString());
    }


}
