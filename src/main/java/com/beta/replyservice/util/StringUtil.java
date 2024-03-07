package com.beta.replyservice.util;

public class StringUtil {

    public static String reverseString(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = message.length() - 1; i >= 0; i--) {
            stringBuilder.append(message.charAt(i));
        }
        return stringBuilder.toString();
    }
}
