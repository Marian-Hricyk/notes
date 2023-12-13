package com.Program1.notes.Service;

import com.Program1.notes.entyty.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteService {
  private final Map<Long, Note> noteMap = new HashMap<>();

  public List<Note> listAll() {
    return new ArrayList<>(noteMap.values());
  }

  public Note add(Note note) {
    Long id = generateUniqueId();
    note.setId(id);
    noteMap.put(id, note);
    return note;
  }

  public void deleteById(long id) {
    if (!noteMap.containsKey(id)) {
      throw new RuntimeException("Note not found with id: " + id);
    }
    noteMap.remove(id);
  }

  public void update(Note note) {
    Long id = note.getId();
    if (!noteMap.containsKey(id)) {
      throw new RuntimeException("Note not found with id: " + id);
    }
    noteMap.put(id, note);
  }

  public Note getById(long id) {
    if (!noteMap.containsKey(id)) {
      throw new RuntimeException("Note not found with id: " + id);
    }
    return noteMap.get(id);
  }

  private Long generateUniqueId() {
    return System.currentTimeMillis();
  }
}
