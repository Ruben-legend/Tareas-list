package com.api.tarea.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.tarea.models.Tarea;
import com.api.tarea.repositories.TareaRepository;

@Service
public class TareaService {

  @Autowired
  private TareaRepository tareaRepository;

  public List<Tarea> findAll() {
    var tarealist = tareaRepository.findAll();
    return tarealist;
  }

  @Transactional
  public Optional<Tarea> findById(int id) {
    return tareaRepository.findById(id);
  }

  @Transactional
  public Optional<Tarea> save(Tarea t) {
    var p = tareaRepository.save(t);
    return Optional.of(p);
  }

  @Transactional
  public void update(int id, Tarea t) {
    t.setId(id);
    tareaRepository.save(t);
  }

  @Transactional
  public Boolean delete(int id) {
    var t = findById(id);
    if (t.isPresent()) {
      tareaRepository.delete(t.get());
      return true;
    }
    return false;
  }
}
