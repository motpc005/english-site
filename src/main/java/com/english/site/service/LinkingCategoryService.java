package com.english.site.service; 

import java.util.List;

import org.springframework.stereotype.Service;

import com.english.site.entity.LinkingCategoryEntity;
import com.english.site.repository.LinkingCategoryRepository;

@Service
public class LinkingCategoryService {

	// ---------- Fields (Dependencies) ----------
	private final LinkingCategoryRepository linkingCategoryRepository;

	// ---------- Constructor ----------
	public LinkingCategoryService(LinkingCategoryRepository linkingCategoryRepository) {
		this.linkingCategoryRepository = linkingCategoryRepository;
	}

	// ---------- Methods ----------
	public List<LinkingCategoryEntity> getAllCategories() {
		return linkingCategoryRepository.findAll();
	}

	public LinkingCategoryEntity createLinkingCategory(
			String name, String description, Integer displayOrder) {

		LinkingCategoryEntity category = new LinkingCategoryEntity(name, description, displayOrder);

		return linkingCategoryRepository.save(category);
	}

	public void deleteLinkingCategory(Long id) {
		linkingCategoryRepository.deleteById(id);
	}

	public LinkingCategoryEntity editLinkingCategory(
			Long id, String name, String description, Integer displayOrder) {

		LinkingCategoryEntity category = linkingCategoryRepository.findById(id)
				.orElseThrow();

		category.setName(name);
		category.setDescription(description);
		category.setDisplayOrder(displayOrder);

		return linkingCategoryRepository.save(category);
	}

	public LinkingCategoryEntity getCategoryById(Long id) {
		return linkingCategoryRepository.findById(id)
				.orElseThrow();
	}
}
