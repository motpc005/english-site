package com.english.site.entity;

import jakarta.persistence.Entity;
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
@Table(name = "vocabulary_sense_situations", uniqueConstraints = {
		@UniqueConstraint(name = "uk_vocabulary_sense_situation", columnNames = { "sense_id", "situation_id" })
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularySenseSituationEntity {

	// ---------- Primary Key ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ---------- Sense Relationship ----------
	// Connects this assignment to a specific vocabulary meaning.
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sense_id", nullable = false)
	private VocabularySenseEntity sense;

	// ---------- Situation Relationship ----------
	// Connects this assignment to a learning situation.
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "situation_id", nullable = false)
	private VocabularySituationEntity situation;

	// ---------- Constructor ----------
	public VocabularySenseSituationEntity(
			VocabularySenseEntity sense,
			VocabularySituationEntity situation) {

		this.sense = sense;
		this.situation = situation;
	}

}