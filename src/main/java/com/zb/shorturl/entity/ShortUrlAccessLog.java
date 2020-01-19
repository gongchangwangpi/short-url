package com.zb.shorturl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 短链接访问日志表
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShortUrlAccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 短链接
     */
    private String shortUrl;

    /**
     * 访问IP地址
     */
    private String accessIp;

    /**
     * 访问时间
     */
    private LocalDateTime accessTime;

}
