package com.edwin.galeriademo.service;

import com.edwin.galeriademo.model.foto;

import java.util.Optional;

public interface fotoService {
    public foto save(foto foto);
    public Optional<foto> get(Integer id);
    public void update(foto foto);
    public void delete(foto foto);
}
