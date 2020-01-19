package com.zb.shorturl.mapper;

import com.zb.shorturl.entity.AppUser;

/**
 * <p>
 * 应用信息表 Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-19
 */
public interface AppUserMapper {

    int insert(AppUser appUser);

    AppUser selectByAppKey(String appKey);

}
