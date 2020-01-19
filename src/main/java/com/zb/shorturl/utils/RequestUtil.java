package com.zb.shorturl.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public class RequestUtil {

    private static final String DEFAULT_IP = "0.0.0.0";

    public static String getClientIp(HttpServletRequest request) {
        return DEFAULT_IP;
    }

}
