package com.andraspatka.docker.backend.demo.service;

import com.andraspatka.docker.backend.demo.model.Hello;
import com.andraspatka.docker.backend.demo.model.HelloRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloServiceTest {

    private HelloService helloService = new HelloService();

    @Test
    void getHelloMessage_callerNull() {
        HelloRequest helloRequest = new HelloRequest();
        Hello hello = helloService.getHelloMessage(helloRequest);

        assertThat(hello.getMessage()).isEqualTo("Hello there, Stranger!");
        assertThat(hello.getDateTime()).isBefore(LocalDateTime.now());
    }

    @Test
    void getHelloMessage_requestNull() {
        Hello hello = helloService.getHelloMessage(null);

        assertThat(hello.getMessage()).isEqualTo("Hello there, Stranger!");
        assertThat(hello.getDateTime()).isBefore(LocalDateTime.now());
    }

    @Test
    void getHelloMessage() {
        HelloRequest helloRequest = new HelloRequest("Andras");
        Hello hello = helloService.getHelloMessage(helloRequest);

        assertThat(hello.getMessage()).isEqualTo("Hello there, Andras!");
        assertThat(hello.getDateTime()).isBefore(LocalDateTime.now());
    }
}
