package com.zb.shorturl.service;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
public interface AppUserService {

    /**
     * when the app key is valid, return {@code true},
     * otherwise return {@code false}
     *
     * @param appKey
     * @return
     */
    boolean verifyAppKey(String appKey);

}
