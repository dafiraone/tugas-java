package com.sistemakademik.sistemakademik.converter;

import com.sistemakademik.sistemakademik.entity.Dosen;
import com.sistemakademik.sistemakademik.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DosenConverter implements Converter<String, Dosen> {

    @Autowired
    private DosenService dosenService;

    @Override
    public Dosen convert(String source) {
        int id = Integer.parseInt(source);
        return dosenService.getDosenById(id);
    }
}
