package com.sistemakademik.sistemakademik.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistemakademik.sistemakademik.entity.Mahasiswa;
import com.sistemakademik.sistemakademik.repository.MahasiswaRepository;
import com.sistemakademik.sistemakademik.service.MahasiswaService;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    private final MahasiswaRepository mhsRepository;

    @Autowired
    public MahasiswaServiceImpl(MahasiswaRepository mhsRepository) {
        this.mhsRepository = mhsRepository;
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return mhsRepository.findAll();
    }

    @Override
    public Mahasiswa saveMahasiswa(Mahasiswa mhs) {
        return mhsRepository.save(mhs);
    }

    @Override
    public Mahasiswa getMahasiswaById(Integer id) {
        return mhsRepository.findById(id).orElse(null);
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mhs) {
        if (mhsRepository.existsById(mhs.getRecNo())) {
            return mhsRepository.save(mhs);
        }
        return null;
    }

    @Override
    public void deleteMahasiswaById(Integer id) {
        mhsRepository.deleteById(id);
    }
}
