package com.zb.shorturl.mapper;

import com.zb.shorturl.entity.ShortUrlAccessLog;

/**
 * <p>
 * 短链接访问日志表 Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-19
 */
public interface ShortUrlAccessLogMapper {

    int insert(ShortUrlAccessLog accessLog);

}
