package com.zb.shorturl.mapper;

import com.zb.shorturl.entity.ShortUrl;

/**
 * <p>
 * 短链接表 Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-19
 */
public interface ShortUrlMapper {

    int insert(ShortUrl shortUrl);

    String selectLongUrl(String shortUrl);

}
