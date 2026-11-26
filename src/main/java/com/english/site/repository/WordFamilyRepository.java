package com.english.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.english.site.entity.WordFamilyEntity;

public interface WordFamilyRepository extends JpaRepository<WordFamilyEntity, Long> {

}
