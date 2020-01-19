package com.zb.shorturl.service;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public interface ShortUrlAccessLogService {

    void saveAccessLog(String shortUrl, String accessIp);

}
