package com.andraspatka.docker.backend.demo.service;

import com.andraspatka.docker.backend.demo.model.Hello;
import com.andraspatka.docker.backend.demo.model.HelloRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloServiceTest {

    private static final String STRANGER = "Stranger";
    private static final String USER = "Andras";

    private HelloService helloService = new HelloService();

    @Test
    void getHelloMessage_callerNull() {
        assertHelloService(new HelloRequest(), STRANGER);
    }

    @Test
    void getHelloMessage_requestNull() {
        assertHelloService(null, STRANGER);
    }

    @Test
    void getHelloMessage() {
        assertHelloService(new HelloRequest(USER), USER);
    }

    /*
      Asserts whether the message and the dateTime are correct.
     */
    private void assertHelloService(HelloRequest request, String caller) {
        LocalDateTime before = LocalDateTime.now();
        Hello hello = helloService.getHelloMessage(request);

        String expectedMessage = String.format("Hello there, %s!", caller);
        assertThat(hello.getMessage()).isEqualTo(expectedMessage);
        assertThat(hello.getDateTime()).isBetween(before, LocalDateTime.now());
    }
}
