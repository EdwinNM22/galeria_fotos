package com.edwin.galeriademo.service;

import com.edwin.galeriademo.model.album;

import java.util.List;
import java.util.Optional;

public interface albumService {
    public album save(album album);
    public Optional<album> get(Integer id);
    public void update(album album);
    public void delete(Integer id);
    public List<album> findAll();
}
