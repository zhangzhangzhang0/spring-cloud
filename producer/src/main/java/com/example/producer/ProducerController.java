package com.example.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @RequestMapping("/producer/haha")
    public String produce(){
        return "成功了";
    }
}
