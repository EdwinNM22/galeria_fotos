package com.edwin.galeriademo.repository;

import com.edwin.galeriademo.model.foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fotoRepository extends JpaRepository<foto, Integer> {
}
