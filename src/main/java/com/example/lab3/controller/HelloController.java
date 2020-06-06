package com.example.lab3.controller;
import com.example.lab3.response.GreetingResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins="*")
    @RequestMapping("/hello")
    public String hello() {
        return "/test";
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "this is test";
    }


    @CrossOrigin(origins="*")
    @RequestMapping("/greeting")
    public GreetingResponse greeting(@RequestParam(value = "name", defaultValue =
            "World") String name) {
        return new GreetingResponse(counter.incrementAndGet(), "Hello, " + name +
                "!");
    }

}
