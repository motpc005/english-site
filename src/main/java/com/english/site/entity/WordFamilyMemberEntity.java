package com.english.site.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "word_family_members")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WordFamilyMemberEntity {

    // ---------- Primary Key ----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- Word Family Relationship ----------
    // Connects this word to its word family.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private WordFamilyEntity family;

    // ---------- Vocabulary Word Relationship ----------
    // Optionally connects this family member to a vocabulary word entry.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id")
    private VocabularyWordEntity word;

    // ---------- Word Family Member Fields ----------
    // The actual word form, such as "employer".
    @Column(nullable = false, length = 100)
    private String wordForm;

    // The grammatical category of this word form.
    @Enumerated(EnumType.STRING)
    @Column(name = "part_of_speech", nullable = false, length = 20)
    private PartOfSpeech partOfSpeech;

    // ---------- Constructor ----------
    public WordFamilyMemberEntity(
            WordFamilyEntity family,
            VocabularyWordEntity word,
            String wordForm,
            PartOfSpeech partOfSpeech) {

        this.family = family;
        this.word = word;
        this.wordForm = wordForm;
        this.partOfSpeech = partOfSpeech;
    }

}
