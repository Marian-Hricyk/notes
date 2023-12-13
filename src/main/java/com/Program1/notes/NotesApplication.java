package com.Program1.notes;

import com.Program1.notes.Service.NoteService;
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

      // Adding a new note
      Note note1 = new Note();
      note1.setTitle("Title 1");
      note1.setContent("Content 1");
      Note addedNote = noteService.add(note1);
      System.out.println("Added note: " + addedNote);

      // Retrieving a note by ID
      long noteId = addedNote.getId();
      Note retrievedNote = noteService.getById(noteId);
      System.out.println("Retrieved note: " + retrievedNote);

      // Updating a note
      retrievedNote.setTitle("Updated title");
      retrievedNote.setContent("Updated content");
      noteService.update(retrievedNote);
      System.out.println("Note after update: " + retrievedNote);

      // Deleting a note
      noteService.deleteById(noteId);
      System.out.println("Note deleted");

      // Displaying all notes
      System.out.println("All notes: " + noteService.listAll());
    };
  }
}
