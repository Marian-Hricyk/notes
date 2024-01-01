package com.Program1.notes;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.Program1.notes")
public class NotesApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotesApplication.class, args);
  }


}
