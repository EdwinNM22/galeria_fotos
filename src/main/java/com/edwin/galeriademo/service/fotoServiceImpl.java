package com.edwin.galeriademo.service;

import com.edwin.galeriademo.model.foto;
import com.edwin.galeriademo.repository.fotoRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class fotoServiceImpl implements fotoService{

    @Autowired
    private fotoRepository fotoRepository;

    @Override
    public foto save(foto foto) {
        return fotoRepository.save(foto);
    }

    @Override
    public Optional<foto> get(Integer id) {
        return fotoRepository.findById(id);
    }

    @Override
    public void update(foto foto) {
        fotoRepository.save(foto);
    }

    @Override
    public void delete(foto foto) {
        fotoRepository.deleteById(foto.getId());

    }
}
