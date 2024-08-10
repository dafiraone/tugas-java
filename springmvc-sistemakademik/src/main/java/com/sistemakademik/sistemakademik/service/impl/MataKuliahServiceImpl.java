package com.sistemakademik.sistemakademik.service.impl;

import com.sistemakademik.sistemakademik.entity.MataKuliah;
import com.sistemakademik.sistemakademik.repository.MataKuliahRepository;
import com.sistemakademik.sistemakademik.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MataKuliahServiceImpl implements MataKuliahService {

    private final MataKuliahRepository mataKuliahRepository;

    @Autowired
    public MataKuliahServiceImpl(MataKuliahRepository mataKuliahRepository) {
        this.mataKuliahRepository = mataKuliahRepository;
    }

    @Override
    public List<MataKuliah> getAllMataKuliah() {
        return mataKuliahRepository.findAll();
    }

    @Override
    public void saveMataKuliah(MataKuliah mataKuliah) {
        mataKuliahRepository.save(mataKuliah);
    }

    @Override
    public MataKuliah getMataKuliahById(int id) {
        return mataKuliahRepository.findById(id).orElse(null);
    }

    @Override
    public void updateMataKuliah(MataKuliah mataKuliah) {
        mataKuliahRepository.save(mataKuliah);
    }

    @Override
    public void deleteMataKuliahById(int id) {
        mataKuliahRepository.deleteById(id);
    }
}
