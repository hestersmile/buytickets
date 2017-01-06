package com.common;

import java.util.UUID;

/**
 * Created by hestersmile on 2016/12/28.
 */
public class StringUtil {
    public static String getUniqueFileName() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }
}
