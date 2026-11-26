package com.english.site.repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.english.site.entity.GrammarCategoryEntity;

public interface GrammarCategoryRepository extends JpaRepository<GrammarCategoryEntity, Long> {

}
