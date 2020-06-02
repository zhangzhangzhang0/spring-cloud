package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Autowired(required = false)
    private FeignClientService feignClientService;

 //   @Autowired
   // private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "executeHystrixHandle")
    @RequestMapping("/api/test/haha/get")
    public String consumer(){
       // return this.restTemplate.getForObject("http://localhost:6110/producer/haha", String.class);
        return feignClientService.consumer();
    }

    //服务进入保护时，回调方法

    public String executeHystrixHandle() {
        return  "Hello, the current system has a large number of people, please try again later, please forgive me for the inconvenience! ! !";

    }


}

