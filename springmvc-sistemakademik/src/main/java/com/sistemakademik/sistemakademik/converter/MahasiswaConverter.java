package com.sistemakademik.sistemakademik.converter;

import com.sistemakademik.sistemakademik.entity.Mahasiswa;
import com.sistemakademik.sistemakademik.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MahasiswaConverter implements Converter<String, Mahasiswa> {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Override
    public Mahasiswa convert(String source) {
        int id = Integer.parseInt(source);
        return mahasiswaService.getMahasiswaById(id);
    }
}
