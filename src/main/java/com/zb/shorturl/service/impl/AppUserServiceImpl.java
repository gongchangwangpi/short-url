package com.zb.shorturl.service.impl;

import com.zb.shorturl.entity.AppUser;
import com.zb.shorturl.mapper.AppUserMapper;
import com.zb.shorturl.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public boolean verifyUser(String appKey) {
        AppUser appUser = appUserMapper.selectByAppKey(appKey);
        if (appUser == null) {
            return false;
        }
        return appUser.getStatus() != null && appUser.getStatus() == 1;
    }
}
