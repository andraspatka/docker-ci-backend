package com.andraspatka.docker.backend.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Hello {

    private String message;
    private LocalDateTime dateTime;

}
