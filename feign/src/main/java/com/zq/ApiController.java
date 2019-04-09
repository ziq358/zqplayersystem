package com.zq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private FeignTestApiService feignTestApiService;//编译器报错，但实际可以运行

    @RequestMapping("index")
    public String index(){
        return feignTestApiService.index();
    }
}
