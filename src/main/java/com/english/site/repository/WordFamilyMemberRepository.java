package com.english.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.english.site.entity.WordFamilyMemberEntity;

public interface WordFamilyMemberRepository extends JpaRepository<WordFamilyMemberEntity, Long> {

}
