package com.sistemakademik.sistemakademik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sistemakademik.sistemakademik.entity.Mahasiswa;
import com.sistemakademik.sistemakademik.service.MahasiswaService;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    private final MahasiswaService mhsService;

    @Autowired
    public MahasiswaController(MahasiswaService mhsService) {
        this.mhsService = mhsService;
    }

    @GetMapping
    public String listMahasiswa(Model model) {
        model.addAttribute("mahasiswaList", mhsService.getAllMahasiswa());
        return "list_mahasiswa";
    }

    @GetMapping("/new")
    public String createMahasiswaForm(Model model) {
        Mahasiswa mhs = new Mahasiswa();
        model.addAttribute("mahasiswa", mhs);
        return "new_mahasiswa";
    }

    @PostMapping
    public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mhs) {
        mhsService.saveMahasiswa(mhs);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/edit/{id}")
    public String editMahasiswaForm(@PathVariable("id") Integer id, Model model) {
        Mahasiswa mhs = mhsService.getMahasiswaById(id);
        model.addAttribute("mahasiswa", mhs);
        return "edit_mahasiswa";
    }

    @PostMapping("/{id}")
    public String updateMahasiswa(@PathVariable("id") Integer id, @ModelAttribute("mahasiswa") Mahasiswa mhs) {
        Mahasiswa existingMhs = mhsService.getMahasiswaById(id);
        existingMhs.setNama(mhs.getNama());
        existingMhs.setNrp(mhs.getNrp());
        existingMhs.setStatus(mhs.getStatus());
        mhsService.updateMahasiswa(existingMhs);
        return "redirect:/mahasiswa";
    }

    @GetMapping("/delete/{id}")
    public String deleteMahasiswa(@PathVariable("id") Integer id) {
        mhsService.deleteMahasiswaById(id);
        return "redirect:/mahasiswa";
    }
}
