package com.zb.shorturl.mapper;

import com.zb.shorturl.entity.ShortUrlNum;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 短链接号码表 Mapper 接口
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-20
 */
public interface ShortUrlNumMapper {

    int insert(ShortUrlNum shortUrlNum);

    int update(@Param("id") int id, @Param("deltaNum") int deltaNum);

    long selectNum(int id);
}
