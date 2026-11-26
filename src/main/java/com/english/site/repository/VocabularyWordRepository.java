package com.english.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.english.site.entity.VocabularyWordEntity;

public interface VocabularyWordRepository extends JpaRepository<VocabularyWordEntity, Long> {

}
