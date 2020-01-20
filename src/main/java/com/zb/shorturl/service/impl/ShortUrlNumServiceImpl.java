package com.zb.shorturl.service.impl;

import com.zb.shorturl.mapper.ShortUrlNumMapper;
import com.zb.shorturl.service.ShortUrlNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangbo
 * @date 2020-01-20
 */
@Service
public class ShortUrlNumServiceImpl implements ShortUrlNumService {

    @Autowired
    private ShortUrlNumMapper shortUrlNumMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public long getCurrentNum() {
        shortUrlNumMapper.update(1, 1);
        return shortUrlNumMapper.selectNum(1);
    }
}
