package com.rxlxr.qxeducation.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjToMap {
    public static Map<String, Object> convertObjectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();

        // Using reflection to access fields
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // Set accessible to access private fields if any
            try {
                Object value = field.get(obj);
                map.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle or log the exception based on your use case
            }
        }

        return map;
    }
}
