package com.english.site.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.english.site.entity.VocabularySituationEntity;
import com.english.site.repository.VocabularySituationRepository;

@Service
public class VocabularySituationService {

    // ---------- Fields (Dependencies) ----------
    private final VocabularySituationRepository vocabularySituationRepository;

    // ---------- Constructor ----------
    public VocabularySituationService(VocabularySituationRepository vocabularySituationRepository) {
        this.vocabularySituationRepository = vocabularySituationRepository;
    }

    // ---------- Methods ----------
    public List<VocabularySituationEntity> getAllSituations() {
        return vocabularySituationRepository.findAll();
    }

    public VocabularySituationEntity createVocabularySituation(
            String code, String name, String description,
            Integer sortOrder, Boolean isPublished) {

        VocabularySituationEntity situation = new VocabularySituationEntity(
                code, name, description, sortOrder, isPublished);

        return vocabularySituationRepository.save(situation);
    }

    public void deleteVocabularySituation(Long id) {
        vocabularySituationRepository.deleteById(id);
    }

    public VocabularySituationEntity editVocabularySituation(
            Long id, String code, String name, String description,
            Integer sortOrder, Boolean isPublished) {

        VocabularySituationEntity situation = vocabularySituationRepository.findById(id)
                .orElseThrow();

        situation.setCode(code);
        situation.setName(name);
        situation.setDescription(description);
        situation.setSortOrder(sortOrder);
        situation.setIsPublished(isPublished);

        return vocabularySituationRepository.save(situation);
    }

    public VocabularySituationEntity getSituationById(Long id) {
        return vocabularySituationRepository.findById(id)
                .orElseThrow();
    }

}
