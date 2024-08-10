package com.sistemakademik.sistemakademik.repository;

import com.sistemakademik.sistemakademik.entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Integer> {
}
