package com.Program1.notes.controlert;

import lombok.extern.slf4j.Slf4j;
import com.Program1.notes.service.NoteService;
import com.Program1.notes.entyty.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/note")
public class Controler {
  NoteService noteService;

  @Autowired
  public Controler(NoteService noteService) {
    this.noteService = noteService;
  }

  @GetMapping("/list")
  public String getNoteList(Model model) {
    List<Note> notes = noteService.listAll();
    model.addAttribute("notes", notes);
    return "noteList";
  }

  @GetMapping("/add")
  public String getAddnote() {
    return "add";
  }

  @GetMapping("/edit/{id}")
  public String getEditNoteForm(@PathVariable Long id, Model model) {
    Note note = noteService.getById(id);
    model.addAttribute("note", note);
    return "note-edit";
  }

  @PostMapping("/edit")
  public String editNote(@ModelAttribute Note editedNote) {
    noteService.update(editedNote);
    return "redirect:/note/list";
  }

  @PostMapping("/delete")
  public String deleteNote(@RequestParam Long id) {
    noteService.deleteById(id);
    return "redirect:/note/list";
  }

  @PostMapping("/add")
  public String addNote(@RequestParam String title, @RequestParam String content) {
    Note note = new Note();
    note.setContent(content);
    note.setTitle(title);
    noteService.add(note);
    return "redirect:/note/list";
  }
}
