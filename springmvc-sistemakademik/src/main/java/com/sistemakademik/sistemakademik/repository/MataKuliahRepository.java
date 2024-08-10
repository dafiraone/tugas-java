package com.sistemakademik.sistemakademik.repository;

import com.sistemakademik.sistemakademik.entity.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataKuliahRepository extends JpaRepository<MataKuliah, Integer> {
}
