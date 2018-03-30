package com.github.wotchin.utils;

public final class TextUtils {
    public TextUtils() {
    }

    public static boolean isEmpty(CharSequence s) {
        if (s == null) {
            return true;
        } else {
            return s.length() == 0;
        }
    }

    public static boolean isBlank(CharSequence s) {
        if (s == null) {
            return true;
        } else {
            for(int i = 0; i < s.length(); ++i) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}

