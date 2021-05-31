package com.example.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "printCopy")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintCopy{

	@Id
	@Column(name= "printCopyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name= "pages")
	private int pages;
	
	@Column(name= "kilograms")
	private double kg;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
	private Book book;

}


