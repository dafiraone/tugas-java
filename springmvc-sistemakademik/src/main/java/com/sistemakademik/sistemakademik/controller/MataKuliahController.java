package com.sistemakademik.sistemakademik.controller;

import com.sistemakademik.sistemakademik.entity.MataKuliah;
import com.sistemakademik.sistemakademik.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mk")
public class MataKuliahController {

    private final MataKuliahService mataKuliahService;

    @Autowired
    public MataKuliahController(MataKuliahService mataKuliahService) {
        this.mataKuliahService = mataKuliahService;
    }

    @GetMapping
    public String listMataKuliah(Model model) {
        model.addAttribute("mataKuliahList", mataKuliahService.getAllMataKuliah());
        return "list_mk";
    }

    @GetMapping("/new")
    public String createMataKuliahForm(Model model) {
        MataKuliah mataKuliah = new MataKuliah();
        model.addAttribute("mataKuliah", mataKuliah);
        return "new_mk";
    }

    @PostMapping
    public String saveMataKuliah(@ModelAttribute("mataKuliah") MataKuliah mataKuliah) {
        mataKuliahService.saveMataKuliah(mataKuliah);
        return "redirect:/mk";
    }

    @GetMapping("/edit/{id}")
    public String editMataKuliahForm(@PathVariable("id") Integer id, Model model) {
        MataKuliah mataKuliah = mataKuliahService.getMataKuliahById(id);
        model.addAttribute("mataKuliah", mataKuliah);
        return "edit_mk";
    }

    @PostMapping("/{id}")
    public String updateMataKuliah(@PathVariable("id") Integer id,
            @ModelAttribute("mataKuliah") MataKuliah mataKuliah) {
        MataKuliah existingMataKuliah = mataKuliahService.getMataKuliahById(id);
        existingMataKuliah.setIdMk(mataKuliah.getIdMk());
        existingMataKuliah.setMk(mataKuliah.getMk());
        mataKuliahService.updateMataKuliah(existingMataKuliah);
        return "redirect:/mk";
    }

    @GetMapping("/delete/{id}")
    public String deleteMataKuliah(@PathVariable("id") Integer id) {
        mataKuliahService.deleteMataKuliahById(id);
        return "redirect:/mk";
    }
}
