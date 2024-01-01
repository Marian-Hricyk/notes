package com.Program1.notes.repository;

import com.Program1.notes.entyty.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
  List<Note> findAll();

  Note save(Note note);

  void deleteById(Long id);

  Note findById(long id);
}
