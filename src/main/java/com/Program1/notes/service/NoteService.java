package com.Program1.notes.service;

import com.Program1.notes.entyty.Note;
import com.Program1.notes.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
  private final NoteRepository noteRepository;

  @Autowired
  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public List<Note> listAll() {
    return noteRepository.findAll();
  }

  public Note add(Note note) {
    return noteRepository.save(note);
  }

  public void deleteById(long id) {
    noteRepository.deleteById(id);
  }


  public Note getById(long id) {
    return noteRepository.findById(id);
  }

  public Note update(Note updatedNote) {

    Note existingNote = noteRepository.findById(updatedNote.getId())
            .orElseThrow(() -> new EntityNotFoundException("Note not found with id: " + updatedNote.getId()));


    existingNote.setTitle(updatedNote.getTitle());
    existingNote.setContent(updatedNote.getContent());


    return noteRepository.save(existingNote);
  }
}