package com.english.site.repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.english.site.entity.LinkingCategoryEntity;

public interface LinkingCategoryRepository extends JpaRepository<LinkingCategoryEntity, Long> {

}
