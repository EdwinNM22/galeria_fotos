package com.edwin.galeriademo.repository;

import com.edwin.galeriademo.model.album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface albumRepository extends JpaRepository<album, Integer> {
}
