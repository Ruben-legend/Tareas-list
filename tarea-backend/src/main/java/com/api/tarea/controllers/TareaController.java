package com.api.tarea.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarea.models.Tarea;
import com.api.tarea.services.TareaService;

@RestController
@RequestMapping("api/tarea/")
public class TareaController {

  @Autowired
  private TareaService tareaService;

  @GetMapping
  private ResponseEntity<List<Tarea>> getTarea() {
    return new ResponseEntity<List<Tarea>>(tareaService.findAll(), HttpStatus.OK);
  }

  @GetMapping("{id}")
  private ResponseEntity<Tarea> getTareaById(@PathVariable int id) {
    var t = tareaService.findById(id);
    if (t.isPresent()) {
      return new ResponseEntity<Tarea>(t.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  private ResponseEntity<?> saveTarea(@RequestBody Tarea t) {
    tareaService.save(t);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
  }

  @DeleteMapping("{id}")
  private ResponseEntity<?> deleteTarea(@PathVariable int id) {
    var s = tareaService.delete(id);
    if (s) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

}
