package com.sistemakademik.sistemakademik.controller;

import com.sistemakademik.sistemakademik.entity.Nilai;
import com.sistemakademik.sistemakademik.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nilai")
public class NilaiController {

    private final NilaiService nilaiService;
    private final MahasiswaService mahasiswaService;
    private final DosenService dosenService;
    private final MataKuliahService mataKuliahService;

    @Autowired
    public NilaiController(NilaiService nilaiService, MahasiswaService mahasiswaService, DosenService dosenService,
            MataKuliahService mataKuliahService) {
        this.nilaiService = nilaiService;
        this.mahasiswaService = mahasiswaService;
        this.dosenService = dosenService;
        this.mataKuliahService = mataKuliahService;
    }

    @GetMapping
    public String listNilai(Model model) {
        model.addAttribute("nilaiList", nilaiService.getAllNilai());
        return "list_nilai";
    }

    @GetMapping("/new")
    public String createNilaiForm(Model model) {
        Nilai nilai = new Nilai();
        model.addAttribute("nilai", nilai);
        model.addAttribute("mahasiswaList", mahasiswaService.getAllMahasiswa());
        model.addAttribute("dosenList", dosenService.getAllDosen());
        model.addAttribute("mataKuliahList", mataKuliahService.getAllMataKuliah());
        return "new_nilai";
    }

    @PostMapping
    public String saveNilai(@ModelAttribute("nilai") Nilai nilai) {
        nilaiService.saveNilai(nilai);
        return "redirect:/nilai";
    }

    @GetMapping("/edit/{id}")
    public String editNilaiForm(@PathVariable("id") Integer id, Model model) {
        Nilai nilai = nilaiService.getNilaiById(id);
        model.addAttribute("nilai", nilai);
        model.addAttribute("mahasiswaList", mahasiswaService.getAllMahasiswa());
        model.addAttribute("dosenList", dosenService.getAllDosen());
        model.addAttribute("mataKuliahList", mataKuliahService.getAllMataKuliah());
        return "edit_nilai";
    }

    @PostMapping("/{id}")
    public String updateNilai(@PathVariable("id") Integer id, @ModelAttribute("nilai") Nilai nilai) {
        Nilai existingNilai = nilaiService.getNilaiById(id);
        existingNilai.setMahasiswa(nilai.getMahasiswa());
        existingNilai.setDosen(nilai.getDosen());
        existingNilai.setMataKuliah(nilai.getMataKuliah());
        existingNilai.setSc1(nilai.getSc1());
        existingNilai.setSc2(nilai.getSc2());
        existingNilai.setSc3(nilai.getSc3());
        nilaiService.updateNilai(existingNilai);
        return "redirect:/nilai";
    }

    @GetMapping("/delete/{id}")
    public String deleteNilai(@PathVariable("id") Integer id) {
        nilaiService.deleteNilaiById(id);
        return "redirect:/nilai";
    }
}
