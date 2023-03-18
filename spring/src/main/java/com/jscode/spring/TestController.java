package com.jscode.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/name")
    public String name() {
        log.info("name=sanghyeok");
        return "sangHyeok";
    }

    @GetMapping("/")
    public String ownName(@RequestParam String name) {
        log.info("name={}", name);
        return name;
    }

//    @GetMapping("/name")
//    public String checkName(@RequestParam(required = false) String name) {
//        if (name == null) {
//            log.info("name=sanghyeok");
//            return "sangheok";
//        }
//        log.info("name={}", name);
//        return name;
//    }


}
