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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "eBook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ebook{

	@Id
	@Column(name = "eBookId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "size")
	private double size;

	@ManyToOne
	@JoinColumn(name = "format_id")
	private FormatType format;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
	private Book book;

}


