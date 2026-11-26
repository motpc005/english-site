package com.english.site.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.english.site.entity.LinkingCategoryEntity;
import com.english.site.service.LinkingCategoryService;

@Controller
public class LinkingCategoryController {

	// ---------- Fields (Dependencies) ----------
	private final LinkingCategoryService linkingCategoryService;

	// ---------- Constructor ----------
	public LinkingCategoryController(LinkingCategoryService linkingCategoryService) {
		this.linkingCategoryService = linkingCategoryService;
	}

	// ---------- Request Handlers (Method Declarations) ----------
	
	// ---------- Public User Page ----------
	@GetMapping("/linking")
	public String showLinkingPage() {
		return "linking/index";
	}
	
	// ---------- Admin Category Management ----------
	
	@GetMapping("/admin/linking")
	public String showLinkingCategories(Model model) {
		model.addAttribute("categories", linkingCategoryService.getAllCategories());
		return "admin/linking/list";
	}

	@PostMapping("/admin/linking/categories")
	public String createLinkingCategory(
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam Integer displayOrder) {

		linkingCategoryService.createLinkingCategory(name, description, displayOrder);
		return "redirect:/admin/linking";
	}

	@PostMapping("/admin/linking/categories/{id}/delete")
	public String deleteLinkingCategory(@PathVariable Long id) {
		linkingCategoryService.deleteLinkingCategory(id);
		return "redirect:/admin/linking";
	}

	@PostMapping("/admin/linking/categories/{id}/edit")
	public String editLinkingCategory(
			@PathVariable Long id,
			@RequestParam String name,
			@RequestParam String description,
			@RequestParam Integer displayOrder) {

		linkingCategoryService.editLinkingCategory(id, name, description, displayOrder);
		return "redirect:/admin/linking";
	}

	@GetMapping("/admin/linking/categories/{id}/edit")
	public String showEditCategoryForm(@PathVariable Long id, Model model) {
		LinkingCategoryEntity category = linkingCategoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "admin/linking/edit-category";
	}
}