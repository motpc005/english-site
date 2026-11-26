package com.english.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.english.site.entity.VocabularySituationEntity;
import com.english.site.service.VocabularySituationService;

@Controller
public class VocabularySituationController {

    // ---------- Fields (Dependencies) ----------
    private final VocabularySituationService vocabularySituationService;

    // ---------- Constructor ----------
    public VocabularySituationController(VocabularySituationService vocabularySituationService) {
        this.vocabularySituationService = vocabularySituationService;
    }

    // ---------- Request Handlers (Method Declarations) ----------

    // ---------- Public User Page ----------
    @GetMapping("/vocabulary")
    public String showVocabularyPage() {
        return "vocabulary/index";
    }

    // ---------- Admin Situation Management ----------

    @GetMapping("/admin/vocabulary")
    public String showVocabularySituations(Model model) {
        model.addAttribute("categories", vocabularySituationService.getAllSituations());
        return "admin/vocabulary/list";
    }

    @PostMapping("/admin/vocabulary/categories")
    public String createVocabularySituation(
            @RequestParam String code,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Integer sortOrder,
            @RequestParam Boolean isPublished) {

        vocabularySituationService.createVocabularySituation(
                code, name, description, sortOrder, isPublished);

        return "redirect:/admin/vocabulary";
    }

    @PostMapping("/admin/vocabulary/categories/{id}/delete")
    public String deleteVocabularySituation(@PathVariable Long id) {
        vocabularySituationService.deleteVocabularySituation(id);
        return "redirect:/admin/vocabulary";
    }

    @PostMapping("/admin/vocabulary/categories/{id}/edit")
    public String editVocabularySituation(
            @PathVariable Long id,
            @RequestParam String code,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Integer sortOrder,
            @RequestParam Boolean isPublished) {

        vocabularySituationService.editVocabularySituation(
                id, code, name, description, sortOrder, isPublished);

        return "redirect:/admin/vocabulary";
    }

    @GetMapping("/admin/vocabulary/categories/{id}/edit")
    public String showEditSituationForm(@PathVariable Long id, Model model) {
        VocabularySituationEntity situation =
                vocabularySituationService.getSituationById(id);

        model.addAttribute("category", situation);
        return "admin/vocabulary/edit-category";
    }

}
