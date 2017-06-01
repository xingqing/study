package com.codefun.util;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Administrator on 2017/3/9.
 */
public class JacksonMapper {
    private static final ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }


    public static final ObjectMapper getMapper(){
        return mapper;
    }



}
