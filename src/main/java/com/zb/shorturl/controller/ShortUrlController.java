package com.zb.shorturl.controller;

import com.zb.shorturl.dto.ResultDTO;
import com.zb.shorturl.exception.PermissionException;
import com.zb.shorturl.service.AppUserService;
import com.zb.shorturl.service.ShortUrlService;
import com.zb.shorturl.utils.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@RequestMapping(value = "/api")
@RestController
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private AppUserService appUserService;

    /**
     * generate a short url for long url
     *
     * @param longUrl
     * @param appKey
     * @return
     */
    @GetMapping(value = "/short")
    public ResultDTO shortUrl(String longUrl, @RequestHeader(value = "appKey") String appKey) {
        UrlUtil.verifyUrl(longUrl);
        if (appUserService.verifyAppKey(appKey)) {
            return ResultDTO.success(shortUrlService.getShortUrl(longUrl, appKey));
        }
        throw new PermissionException("invalid app key");
    }

    /**
     * query original long url by short url
     *
     * @param shortUrl
     * @param appKey
     * @return
     */
    @GetMapping(value = "/long")
    public ResultDTO longUrl(String shortUrl, @RequestHeader(value = "appKey") String appKey) {
        if (appUserService.verifyAppKey(appKey)) {
            return ResultDTO.success(shortUrlService.getLongUrl(shortUrl));
        }
        throw new PermissionException("invalid app key");
    }

}
