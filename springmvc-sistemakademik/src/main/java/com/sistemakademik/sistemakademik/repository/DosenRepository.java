package com.sistemakademik.sistemakademik.repository;

import com.sistemakademik.sistemakademik.entity.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosenRepository extends JpaRepository<Dosen, Integer> {
}
