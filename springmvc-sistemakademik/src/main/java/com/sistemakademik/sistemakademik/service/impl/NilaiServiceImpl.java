package com.sistemakademik.sistemakademik.service.impl;

import com.sistemakademik.sistemakademik.entity.Nilai;
import com.sistemakademik.sistemakademik.repository.NilaiRepository;
import com.sistemakademik.sistemakademik.service.NilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NilaiServiceImpl implements NilaiService {

    private final NilaiRepository nilaiRepository;

    @Autowired
    public NilaiServiceImpl(NilaiRepository nilaiRepository) {
        this.nilaiRepository = nilaiRepository;
    }

    @Override
    public List<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    @Override
    public void saveNilai(Nilai nilai) {
        nilaiRepository.save(nilai);
    }

    @Override
    public Nilai getNilaiById(int id) {
        return nilaiRepository.findById(id).orElse(null);
    }

    @Override
    public void updateNilai(Nilai nilai) {
        nilaiRepository.save(nilai);
    }

    @Override
    public void deleteNilaiById(int id) {
        nilaiRepository.deleteById(id);
    }
}
