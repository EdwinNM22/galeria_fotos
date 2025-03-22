package com.edwin.galeriademo.repository;

import com.edwin.galeriademo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<usuario, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
