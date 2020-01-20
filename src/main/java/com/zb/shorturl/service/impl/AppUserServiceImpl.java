package com.zb.shorturl.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zb.shorturl.entity.AppUser;
import com.zb.shorturl.mapper.AppUserMapper;
import com.zb.shorturl.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@Slf4j
@Service
public class AppUserServiceImpl implements AppUserService {

    private static Cache<String, AppUser> userCache = CacheBuilder.newBuilder()
            .expireAfterAccess(Duration.ofMinutes(30))
            .concurrencyLevel(8)
            .maximumSize(100000)
            .build();

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public boolean verifyAppKey(String appKey) {
        AppUser appUser = null;
        try {
            appUser = userCache.get(appKey, () -> {
                return appUserMapper.selectByAppKey(appKey);
            });
        } catch (ExecutionException e) {
            //
            log.error("load app key error", e);
        }
        if (appUser == null) {
            return false;
        }
        return appUser.getStatus() != null && appUser.getStatus() == 1;
    }
}
