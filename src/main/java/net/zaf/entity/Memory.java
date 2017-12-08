package net.zaf.entity;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    private static Map<String, Object> map;

    private static void init() {
        map = new HashMap<>();
    }

    public static void put(String key, Object value) {
        if (map == null) {
            init();
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    public static boolean has(String key) {
        return get(key) != null;
    }
}
