package com.zb.shorturl.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhangbo
 * @date 2020-01-20
 */
@Slf4j
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static final ThreadLocal<Long> threadLocalTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        threadLocalTime.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long begin = threadLocalTime.get();
        long end = System.currentTimeMillis();

        String remoteAddr = request.getRemoteAddr();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String protocol = request.getProtocol();
        String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        int code = response.getStatus();
        log.info("{} -- [{}] {} {} {} code {} cost {} millis", remoteAddr, time, method, protocol, requestURI, code, (end - begin));
        threadLocalTime.remove();
    }
}
