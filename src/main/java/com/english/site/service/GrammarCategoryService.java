package com.english.site.service; 

import java.util.List;

import org.springframework.stereotype.Service;

import com.english.site.entity.GrammarCategoryEntity;
import com.english.site.repository.GrammarCategoryRepository;

@Service
public class GrammarCategoryService {

	// ---------- Fields (Dependencies) ----------
	private final GrammarCategoryRepository grammarCategoryRepository;

	// ---------- Constructor ----------
	public GrammarCategoryService(GrammarCategoryRepository grammarCategoryRepository) {
		this.grammarCategoryRepository = grammarCategoryRepository;
	}

	// ---------- Methods ----------
	public List<GrammarCategoryEntity> getAllCategories() {
		return grammarCategoryRepository.findAll();
	}

	public GrammarCategoryEntity createGrammarCategory(
			String name, String description, Integer displayOrder) {

		GrammarCategoryEntity category = new GrammarCategoryEntity(name, description, displayOrder);

		return grammarCategoryRepository.save(category);
	}

	public void deleteGrammarCategory(Long id) {
		grammarCategoryRepository.deleteById(id);
	}

	public GrammarCategoryEntity editGrammarCategory(
			Long id, String name, String description, Integer displayOrder) {

		GrammarCategoryEntity category = grammarCategoryRepository.findById(id)
				.orElseThrow();

		category.setName(name);
		category.setDescription(description);
		category.setDisplayOrder(displayOrder);

		return grammarCategoryRepository.save(category);
	}

	public GrammarCategoryEntity getCategoryById(Long id) {
		return grammarCategoryRepository.findById(id)
				.orElseThrow();
	}
}
