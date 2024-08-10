package com.sistemakademik.sistemakademik.service;

import com.sistemakademik.sistemakademik.entity.Nilai;

import java.util.List;

public interface NilaiService {
    List<Nilai> getAllNilai();

    void saveNilai(Nilai nilai);

    Nilai getNilaiById(int id);

    void updateNilai(Nilai nilai);

    void deleteNilaiById(int id);
}
