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
@Table(name = "vocabulary_situations")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocabularySituationEntity {

	// ---------- Primary Key ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ---------- Category Fields ----------
	@Column(nullable = false, unique = true, length = 50)
	private String code;
	
	@Column(nullable = false, length = 100)
	private String name;

	@Column(length = 255)
	private String description;

	@Column(name = "sort_order", nullable = false)
	private Integer sortOrder = 0;
	
	@Column(name = "is_published", nullable = false)
	private Boolean isPublished = false;

	// ---------- Constructor ----------
	public VocabularySituationEntity(
			String code, String name, String description, 
			Integer sortOrder, Boolean isPublished) {

		this.code = code;
		this.name = name;
		this.description = description;
		this.sortOrder = sortOrder;
		this.isPublished = isPublished;
	}

}
