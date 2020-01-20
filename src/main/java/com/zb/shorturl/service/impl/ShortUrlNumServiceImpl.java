package com.zb.shorturl.service.impl;

import com.zb.shorturl.mapper.ShortUrlNumMapper;
import com.zb.shorturl.service.ShortUrlNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author zhangbo
 * @date 2020-01-20
 */
@Service
public class ShortUrlNumServiceImpl implements ShortUrlNumService {

    private static volatile long maxNum = 1;
    private static volatile long currentNum = 0;

    @Value("${short-url.cache-count:10}")
    private int cacheCount;

    @Autowired
    private ShortUrlNumMapper shortUrlNumMapper;

    @PostConstruct
    public void init() {
        updateMaxNum();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public synchronized long getCurrentNum() {
        if (currentNum == maxNum) {
            updateMaxNum();
        }
        return ++currentNum;
    }

    private void updateMaxNum() {
        shortUrlNumMapper.update(1, cacheCount);
        maxNum = shortUrlNumMapper.selectNum(1);
        currentNum = maxNum - cacheCount;
    }
}
