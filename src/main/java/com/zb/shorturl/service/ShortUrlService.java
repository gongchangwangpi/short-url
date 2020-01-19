package com.zb.shorturl.service;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public interface ShortUrlService {

    String getShortUrl(String longUrl, String creatorId);

    String getLongUrl(String shortUrl);

}
