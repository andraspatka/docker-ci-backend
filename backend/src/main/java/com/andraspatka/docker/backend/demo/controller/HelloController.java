package com.andraspatka.docker.backend.demo.controller;

import com.andraspatka.docker.backend.demo.model.Hello;
import com.andraspatka.docker.backend.demo.model.HelloRequest;
import com.andraspatka.docker.backend.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController(@Autowired HelloService helloService) {
        this.helloService = helloService;
    }

    @CrossOrigin(origins = {"localhost:80", "localhost:3000"})
    @PutMapping(value = "/greeting", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Hello putGreeting(@RequestBody @Nullable HelloRequest request) {
        return this.helloService.getHelloMessage(request);
    }

    @CrossOrigin(origins = {"localhost:80", "localhost:3000"})
    @GetMapping(value = "/greeting", produces = APPLICATION_JSON_VALUE)
    public Hello getGreeting(@RequestBody @Nullable HelloRequest request) {
        return this.helloService.getHelloMessage(request);
    }

    @CrossOrigin(origins = {"localhost:80", "localhost:3000"})
    @GetMapping(value = "/greeting", produces = APPLICATION_JSON_VALUE)
    public String getHello() {
        return "Hello";
    }
}
