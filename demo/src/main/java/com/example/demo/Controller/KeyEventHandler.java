package com.example.demo.Controller;


import java.util.HashMap;

public class KeyEventHandler {
    private static final HashMap<String, Boolean> pressedKeys = new HashMap<>();

    public static int getStatus(String... keyNames) {
        for (String keyName : keyNames) {
            if (pressedKeys.getOrDefault(keyName, false)) return 1;
        }
        return 0;
    }

    public static void releaseKey(String keyName) {
        pressedKeys.put(keyName, false);
    }

    public static void pressKey(String keyName) {
        pressedKeys.put(keyName, true);
    }

}
