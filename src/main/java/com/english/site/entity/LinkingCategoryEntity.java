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
@Table(name = "linking_category")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LinkingCategoryEntity {

	// ---------- Primary Key ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ---------- Category Fields ----------
	@Column(nullable = false, unique = true, length = 100)
	private String name;

	@Column(length = 500)
	private String description;

	@Column(name = "display_order")
	private Integer displayOrder;

	// ---------- Constructor ----------
	public LinkingCategoryEntity(String name, String description, Integer displayOrder) {
		this.name = name;
		this.description = description;
		this.displayOrder = displayOrder;
	}
}
