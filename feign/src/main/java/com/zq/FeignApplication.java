package com.zq;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }


    /**
     * 访问http://localhost:8010/hystrix 添加 http://ip:port/hystix.stream
     * 低版本直接启动即可使用 http://ip:port/hystrix.stream 查看监控信息
     * 高版本需要添加本方法方可使用 http://ip:port/hystix.stream 查看监控信息
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        //注册Servlet
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        //放入自己的Servlet对象实例
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        //标记容器是否在启动的时候就加载这个servlet,
        // 当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
        registrationBean.setLoadOnStartup(1);
        //访问路径值
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    /**
     * 多个servlet就注册多个bean
     * @return
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean1() {
//        return new ServletRegistrationBean(new MyServlet(), "/servlet/myServlet");// ServletName默认值为首字母小写，即myServlet
//    }

}