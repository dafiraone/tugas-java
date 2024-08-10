package com.sistemakademik.sistemakademik.service;

import java.util.List;
import com.sistemakademik.sistemakademik.entity.Mahasiswa;

public interface MahasiswaService {
    List<Mahasiswa> getAllMahasiswa();

    Mahasiswa saveMahasiswa(Mahasiswa mhs);

    Mahasiswa getMahasiswaById(Integer id);

    Mahasiswa updateMahasiswa(Mahasiswa mhs);

    void deleteMahasiswaById(Integer id);
}
