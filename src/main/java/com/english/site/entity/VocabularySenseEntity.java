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
import jakarta.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "vocabulary_senses",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_vocabulary_sense_word_order",
            columnNames = {"word_id", "sense_order"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularySenseEntity {

    // ---------- Primary Key ----------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- Word Relationship ----------
    // Connects this meaning to its vocabulary word.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "word_id", nullable = false)
    private VocabularyWordEntity word;

    // ---------- Meaning Fields ----------
    // Determines the display order of meanings belonging to the same word.
    @Column(name = "sense_order", nullable = false)
    private Integer senseOrder;

    // Grammatical category, such as noun, verb or adjective.
    @Enumerated(EnumType.STRING)
    @Column(name = "part_of_speech", nullable = false, length = 20)
    private PartOfSpeech partOfSpeech;

    // TOEIC vocabulary learning priority.
    @Enumerated(EnumType.STRING)
    @Column(name = "toeic_frequency", nullable = false, length = 20)
    private ToeicFrequency toeicFrequency;

    // Japanese meaning of this particular sense.
    @Column(name = "meaning_ja", nullable = false, length = 255)
    private String meaningJa;

    // English explanation of the meaning.
    @Column(length = 500, nullable = false)
    private String definition;

    // English example sentence.
    @Column(length = 500, nullable = false)
    private String example;

    // Japanese translation of the example sentence.
    @Column(name = "example_ja", length = 500, nullable = false)
    private String exampleJa;

    // Optional pronunciation override for this particular meaning.
    @Column(name = "ipa_override", length = 100)
    private String ipaOverride;

    // Optional katakana pronunciation override for this meaning.
    @Column(name = "katakana_override", length = 100)
    private String katakanaOverride;

    // Optional notes explaining how this meaning is used.
    @Column(name = "usage_note", columnDefinition = "TEXT")
    private String usageNote;

    // ---------- Constructor ----------
    public VocabularySenseEntity(
            VocabularyWordEntity word,
            Integer senseOrder,
            PartOfSpeech partOfSpeech,
            ToeicFrequency toeicFrequency,
            String meaningJa,
            String definition,
            String example,
            String exampleJa,
            String ipaOverride,
            String katakanaOverride,
            String usageNote) {

        this.word = word;
        this.senseOrder = senseOrder;
        this.partOfSpeech = partOfSpeech;
        this.toeicFrequency = toeicFrequency;
        this.meaningJa = meaningJa;
        this.definition = definition;
        this.example = example;
        this.exampleJa = exampleJa;
        this.ipaOverride = ipaOverride;
        this.katakanaOverride = katakanaOverride;
        this.usageNote = usageNote;
    }

}
