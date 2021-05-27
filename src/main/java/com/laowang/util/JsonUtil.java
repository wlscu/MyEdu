package com.laowang.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 隔壁老王
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object obj){
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
