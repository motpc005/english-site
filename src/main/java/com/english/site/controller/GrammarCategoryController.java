package com.english.site.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.english.site.entity.GrammarCategoryEntity;
import com.english.site.service.GrammarCategoryService;

@Controller
public class GrammarCategoryController {

	// ---------- Fields (Dependencies) ----------
	private final GrammarCategoryService grammarCategoryService;

	// ---------- Constructor ----------
	public GrammarCategoryController(GrammarCategoryService grammarCategoryService) {
		this.grammarCategoryService = grammarCategoryService;
	}

	// ---------- Request Handlers (Method Declarations) ----------
	
	// ---------- Public User Page ----------
	@GetMapping("/grammar")
	public String showGrammarPage() {
		return "grammar/index";
	}
	
	// ---------- Admin Category Management ----------
	
	@GetMapping("/admin/grammar")
	public String showGrammarCategories(Model model) {
		model.addAttribute("categories", grammarCategoryService.getAllCategories());
		return "admin/grammar/list";
	}

	@PostMapping("/admin/grammar/categories")
	public String createGrammarCategory(
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam Integer displayOrder) {

		grammarCategoryService.createGrammarCategory(name, description, displayOrder);
		return "redirect:/admin/grammar";
	}

	@PostMapping("/admin/grammar/categories/{id}/delete")
	public String deleteGrammarCategory(@PathVariable Long id) {
		grammarCategoryService.deleteGrammarCategory(id);
		return "redirect:/admin/grammar";
	}

	@PostMapping("/admin/grammar/categories/{id}/edit")
	public String editGrammarCategory(
			@PathVariable Long id,
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam Integer displayOrder) {

		grammarCategoryService.editGrammarCategory(id, name, description, displayOrder);
		return "redirect:/admin/grammar";
	}
	
	@GetMapping("/admin/grammar/categories/{id}/edit")
	public String showEditCategoryForm(@PathVariable Long id, Model model) {
		GrammarCategoryEntity category = grammarCategoryService.getCategoryById(id);
		model.addAttribute("category" , category);
		return "admin/grammar/edit-category";
	}

}
