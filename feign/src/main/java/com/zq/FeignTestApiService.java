package com.zq;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//注册到 服务发现中心  的服务名称，同一个服务可能有多个提供者，负载均衡
@FeignClient(value = "eureka-client", fallback = FeignTestApiServiceError.class)
public interface FeignTestApiService {
    // 调用 了远程eureka-client服务
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index();
}
