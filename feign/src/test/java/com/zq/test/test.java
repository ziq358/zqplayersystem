package com.zq.test;

import com.zq.FeignApplication;
import com.zq.FeignTestApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Autowired
    private FeignTestApiService apiService;

    @Test
    public void test(){
        try {
            //测试 内部调用服务负载均衡效果
            System.out.println(apiService.index());
            System.out.println(apiService.index());
            System.out.println(apiService.index());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
