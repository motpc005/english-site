
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
@Table(name = "vocabulary_synonyms")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularySynonymEntity {

	// ---------- Primary Key ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ---------- Sense Relationship ----------
	// Connects this synonym to a specific vocabulary meaning.
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sense_id", nullable = false)
	private VocabularySenseEntity sense;

	// ---------- Synonym Fields ----------
	// The English word or phrase with a similar meaning.
	@Column(nullable = false, length = 100)
	private String synonym;

	// ---------- Constructor ----------
	public VocabularySynonymEntity(
			VocabularySenseEntity sense,
			String synonym) {

		this.sense = sense;
		this.synonym = synonym;
	}

}
