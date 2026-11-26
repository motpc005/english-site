package com.english.site.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "vocabulary_collocations")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularyCollocationEntity {

    // ---------- Primary Key ----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- Sense Relationship ----------
    // Connects this collocation to a specific vocabulary meaning.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sense_id", nullable = false)
    private VocabularySenseEntity sense;

    // ---------- Collocation Fields ----------
    // The English word combination, such as "make a decision".
    @Column(nullable = false, length = 255)
    private String collocation;

    // Optional katakana pronunciation showing how the words sound when connected.
    @Column(name = "katakana_pronunciation", length = 255)
    private String katakanaPronunciation;

    // ---------- Constructor ----------
    public VocabularyCollocationEntity(
            VocabularySenseEntity sense,
            String collocation,
            String katakanaPronunciation) {

        this.sense = sense;
        this.collocation = collocation;
        this.katakanaPronunciation = katakanaPronunciation;
    }

}
