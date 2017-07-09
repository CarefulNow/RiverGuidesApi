package com.bazinga.riverguides.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by bazinga on 7/6/17.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] argc) {
        SpringApplication.run(Application.class, argc);
    }
}
