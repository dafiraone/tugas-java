package com.sistemakademik.sistemakademik.service.impl;

import com.sistemakademik.sistemakademik.entity.Dosen;
import com.sistemakademik.sistemakademik.repository.DosenRepository;
import com.sistemakademik.sistemakademik.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosenServiceImpl implements DosenService {

    private final DosenRepository dosenRepository;

    @Autowired
    public DosenServiceImpl(DosenRepository dosenRepository) {
        this.dosenRepository = dosenRepository;
    }

    @Override
    public List<Dosen> getAllDosen() {
        return dosenRepository.findAll();
    }

    @Override
    public void saveDosen(Dosen dosen) {
        dosenRepository.save(dosen);
    }

    @Override
    public Dosen getDosenById(int id) {
        return dosenRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDosen(Dosen dosen) {
        dosenRepository.save(dosen);
    }

    @Override
    public void deleteDosenById(int id) {
        dosenRepository.deleteById(id);
    }
}
