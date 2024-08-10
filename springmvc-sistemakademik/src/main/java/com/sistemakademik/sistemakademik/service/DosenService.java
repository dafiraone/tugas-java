package com.sistemakademik.sistemakademik.service;

import com.sistemakademik.sistemakademik.entity.Dosen;

import java.util.List;

public interface DosenService {
    List<Dosen> getAllDosen();

    void saveDosen(Dosen dosen);

    Dosen getDosenById(int id);

    void updateDosen(Dosen dosen);

    void deleteDosenById(int id);
}
