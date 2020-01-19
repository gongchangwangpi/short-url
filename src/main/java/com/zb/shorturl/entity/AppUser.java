package com.zb.shorturl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 应用信息表
 * </p>
 *
 * @author zhangbo
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;

    /**
     * app key
     */
    private String appKey;

    /**
     * 状态[0禁用 1正常]
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
