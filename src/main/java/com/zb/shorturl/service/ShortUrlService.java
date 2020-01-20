package com.zb.shorturl.service;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public interface ShortUrlService {

    /**
     * generate short url for long url
     *
     * @param longUrl
     * @param appKey
     * @return
     */
    String getShortUrl(String longUrl, String appKey);

    /**
     * query original long url by short url
     *
     * @param shortUrl
     * @return
     */
    String getLongUrl(String shortUrl);

}
