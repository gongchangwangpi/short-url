package com.zb.shorturl.utils;

import org.springframework.util.StringUtils;

/**
 * @author zhangbo
 * @date 2020-01-20
 */
public class UrlUtil {

    private static final String HTTP_PROTOCOL = "http://";
    private static final String HTTPS_PROTOCOL = "https://";

    public static void verifyUrl(String url) {
        if (!isHttpUrl(url) && !isHttpsUrl(url)) {
            throw new IllegalArgumentException("illegal url: " + url);
        }
    }

    public static boolean isHttpUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }
        return url.toLowerCase().startsWith(HTTP_PROTOCOL);
    }

    public static boolean isHttpsUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }
        return url.toLowerCase().startsWith(HTTPS_PROTOCOL);
    }

}
