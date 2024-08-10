package com.sistemakademik.sistemakademik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sistemakademik.sistemakademik.converter.MahasiswaConverter;
import com.sistemakademik.sistemakademik.converter.DosenConverter;
import com.sistemakademik.sistemakademik.converter.MataKuliahConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MahasiswaConverter mahasiswaConverter;

    @Autowired
    private DosenConverter dosenConverter;

    @Autowired
    private MataKuliahConverter mataKuliahConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(mahasiswaConverter);
        registry.addConverter(dosenConverter);
        registry.addConverter(mataKuliahConverter);
    }
}
