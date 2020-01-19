package com.zb.shorturl.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public class ShortUrlUtil {

    public static final String SHORT_URL_PRE = "short_url:";
    public static final String EMPTY_SHORT_URL = "empty_short_url";

    private static final String[] URL_STR;
    private static final AtomicLong atomicLong = new AtomicLong(1);

    static {
        URL_STR = "qwertyuiopasdfghjklzxcvbnm_0123456789-MNBVCXZASDFGHJKLPOIUYTREWQ".split("");
    }

    public static String shortUrl() {
        long count = atomicLong.getAndIncrement();
        return scale(count, 64);
    }

    private static String scale(long number, int scale) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.insert(0, URL_STR[(int) (number % scale)]);
            number /= scale;
        }
        return result.toString();
    }
}
