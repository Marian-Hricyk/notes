package com.Program1.notes;

import com.Program1.notes.Service.NoteService;
import com.Program1.notes.controlert.Controler;
import com.Program1.notes.entyty.Note;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Program1.notes")
public class NotesApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotesApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(NoteService noteService) {
    return (args) -> {


    };
  }
}
