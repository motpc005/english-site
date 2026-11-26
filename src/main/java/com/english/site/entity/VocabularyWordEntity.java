package com.english.site.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vocabulary_words")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularyWordEntity {

    // ---------- Primary Key ----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- Vocabulary Word Fields ----------
    // The main English word, such as "employ".
    @Column(nullable = false, unique = true, length = 100)
    private String headword;

    // Default IPA pronunciation for the word.
    @Column(length = 100)
    private String ipa;

    // Default katakana pronunciation for the word.
    @Column(length = 100)
    private String katakana;

    // Determines whether this word is visible to website visitors.
    @Column(name = "is_published", nullable = false)
    private Boolean isPublished = false;

    // ---------- Constructor ----------
    public VocabularyWordEntity(
            String headword, String ipa, String katakana, Boolean isPublished) {

        this.headword = headword;
        this.ipa = ipa;
        this.katakana = katakana;
        this.isPublished = isPublished;
    }

}
