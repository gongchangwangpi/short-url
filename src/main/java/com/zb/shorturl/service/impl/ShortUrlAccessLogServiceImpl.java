package com.zb.shorturl.service.impl;

import com.zb.shorturl.entity.ShortUrlAccessLog;
import com.zb.shorturl.mapper.ShortUrlAccessLogMapper;
import com.zb.shorturl.service.ShortUrlAccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author zhangbo
 * @date 2020-01-19
 */
@Service
public class ShortUrlAccessLogServiceImpl implements ShortUrlAccessLogService {

    @Autowired
    private ShortUrlAccessLogMapper shortUrlAccessLogMapper;

    @Override
    @Async
    public void saveAccessLog(String shortUrl, String accessIp) {
        ShortUrlAccessLog accessLog = new ShortUrlAccessLog();
        accessLog.setShortUrl(shortUrl);
        accessLog.setAccessIp(accessIp);
        accessLog.setAccessTime(LocalDateTime.now());
        shortUrlAccessLogMapper.insert(accessLog);
    }
}
