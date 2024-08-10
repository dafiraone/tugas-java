package com.sistemakademik.sistemakademik.converter;

import com.sistemakademik.sistemakademik.entity.MataKuliah;
import com.sistemakademik.sistemakademik.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MataKuliahConverter implements Converter<String, MataKuliah> {

    @Autowired
    private MataKuliahService mataKuliahService;

    @Override
    public MataKuliah convert(String source) {
        int id = Integer.parseInt(source);
        return mataKuliahService.getMataKuliahById(id);
    }
}
