package com.laowang.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * @author 隔壁老王
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object obj){
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
