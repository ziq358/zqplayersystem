package com.zq;

import org.springframework.stereotype.Component;

@Component
public class FeignTestApiServiceError implements FeignTestApiService{
    @Override
    public String index() {
        return "服务发生故障！";
    }
}
