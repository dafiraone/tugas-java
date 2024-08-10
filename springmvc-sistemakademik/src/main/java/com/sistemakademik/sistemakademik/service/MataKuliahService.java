package com.sistemakademik.sistemakademik.service;

import com.sistemakademik.sistemakademik.entity.MataKuliah;

import java.util.List;

public interface MataKuliahService {
    List<MataKuliah> getAllMataKuliah();

    void saveMataKuliah(MataKuliah mataKuliah);

    MataKuliah getMataKuliahById(int id);

    void updateMataKuliah(MataKuliah mataKuliah);

    void deleteMataKuliahById(int id);
}
