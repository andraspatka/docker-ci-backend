package com.andraspatka.docker.backend.demo.service;

import com.andraspatka.docker.backend.demo.model.Hello;
import com.andraspatka.docker.backend.demo.model.HelloRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelloService {

    public Hello getHelloMessage(HelloRequest request) {
        Hello hello = new Hello();
        String caller = (request == null || request.getCaller() == null) ? "Stranger" : request.getCaller();

        hello.setMessage(String.format("Hello there, %s!", caller));
        hello.setDateTime(LocalDateTime.now());

        return hello;
    }
}
