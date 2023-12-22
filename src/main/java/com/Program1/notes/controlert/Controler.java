package com.Program1.notes.controlert;


import com.Program1.notes.Service.NoteService;
import com.Program1.notes.entyty.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/edit")
  public String getEditNoteForm(@RequestParam Long id, Model model) {
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
}
