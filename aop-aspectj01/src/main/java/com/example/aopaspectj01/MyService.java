package com.example.aopaspectj01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {

    public void foo(){
        log.info("foo()");
    }
}
