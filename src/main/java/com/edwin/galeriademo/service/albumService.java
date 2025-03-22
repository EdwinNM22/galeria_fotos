package com.edwin.galeriademo.service;

import com.edwin.galeriademo.model.album;

import java.util.List;
import java.util.Optional;

public interface albumService {
    album save(album album);
    Optional<album> get(Integer id);
    void update(album album);
    void delete(Integer id);
    List<album> findAll();
}
