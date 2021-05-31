package com.example.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//defining constructors, getters and setters
@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	
	@Id
	@Column(name= "authorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name= "name")
	private String name;
	
	@Column(name= "surname")
	private String surname;
	
	@Column(name= "birthYear")
	private int birthYear;
	
}
