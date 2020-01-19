package com.zb.shorturl.controller;

import com.zb.shorturl.service.ShortUrlAccessLogService;
import com.zb.shorturl.service.ShortUrlService;
import com.zb.shorturl.utils.RequestUtil;
import com.zb.shorturl.utils.ShortUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@Controller
public class RedirectController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private ShortUrlAccessLogService shortUrlAccessLogService;

    /**
     * 短链接跳转
     *
     * @param shortUrl
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/s/{shortUrl}")
    public void redirect(@PathVariable(value = "shortUrl") String shortUrl,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        shortUrlAccessLogService.saveAccessLog(shortUrl, RequestUtil.getClientIp(request));
        String longUrl = shortUrlService.getLongUrl(shortUrl);
        if (ShortUrlUtil.EMPTY_SHORT_URL.equalsIgnoreCase(longUrl)) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            response.sendRedirect(longUrl);
        }
    }

}
