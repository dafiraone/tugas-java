package com.sistemakademik.sistemakademik.controller;

import com.sistemakademik.sistemakademik.entity.Dosen;
import com.sistemakademik.sistemakademik.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dosen")
public class DosenController {

    private final DosenService dosenService;

    @Autowired
    public DosenController(DosenService dosenService) {
        this.dosenService = dosenService;
    }

    @GetMapping
    public String listDosen(Model model) {
        model.addAttribute("dosenList", dosenService.getAllDosen());
        return "list_dosen";
    }

    @GetMapping("/new")
    public String createDosenForm(Model model) {
        Dosen dosen = new Dosen();
        model.addAttribute("dosen", dosen);
        return "new_dosen";
    }

    @PostMapping
    public String saveDosen(@ModelAttribute("dosen") Dosen dosen) {
        dosenService.saveDosen(dosen);
        return "redirect:/dosen";
    }

    @GetMapping("/edit/{id}")
    public String editDosenForm(@PathVariable("id") Integer id, Model model) {
        Dosen dosen = dosenService.getDosenById(id);
        model.addAttribute("dosen", dosen);
        return "edit_dosen";
    }

    @PostMapping("/{id}")
    public String updateDosen(@PathVariable("id") Integer id, @ModelAttribute("dosen") Dosen dosen) {
        Dosen existingDosen = dosenService.getDosenById(id);
        existingDosen.setNama(dosen.getNama());
        existingDosen.setNoDos(dosen.getNoDos());
        dosenService.updateDosen(existingDosen);
        return "redirect:/dosen";
    }

    @GetMapping("/delete/{id}")
    public String deleteDosen(@PathVariable("id") Integer id) {
        dosenService.deleteDosenById(id);
        return "redirect:/dosen";
    }
}
