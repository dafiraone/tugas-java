package com.sistemakademik.sistemakademik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemakademik.sistemakademik.entity.Mahasiswa;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
}
