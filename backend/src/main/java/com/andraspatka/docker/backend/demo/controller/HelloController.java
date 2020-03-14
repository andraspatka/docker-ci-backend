package com.andraspatka.docker.backend.demo.controller;

import com.andraspatka.docker.backend.demo.model.Hello;
import com.andraspatka.docker.backend.demo.model.HelloRequest;
import com.andraspatka.docker.backend.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController(@Autowired HelloService helloService) {
        this.helloService = helloService;
    }

    @PutMapping(value = "/greeting", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Hello putGreeting(@RequestBody @Nullable HelloRequest request) {
        return this.helloService.getHelloMessage(request);
    }

    @GetMapping(value = "/greeting", produces = APPLICATION_JSON_VALUE)
    public Hello getGreeting(@RequestBody @Nullable HelloRequest request) {
        return this.helloService.getHelloMessage(request);
    }
}
