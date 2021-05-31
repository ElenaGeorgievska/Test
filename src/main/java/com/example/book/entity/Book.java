package com.example.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@Column(name= "bookId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name= "title")
	private String title;
	
	@Column(name= "isbn")
	private long ISBN;
	
	@Column(name= "releasedYear")
	private int releasedYear;
	
    @ManyToOne
    @JoinColumn(name = "author_id")
	private Author author;
       
    @ManyToOne
	@JoinColumn(name = "type_id")
	private BookTypes type;
    

}
