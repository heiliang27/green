package com.green.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${server.port}")
    String port;
	@Value("${hello}")
    String foo;
    @RequestMapping("/hi")
    public String home(@RequestParam(defaultValue="default") String name) {
        return "hi "+name+",i am from port:" +port+"\n"+foo;
    }
}