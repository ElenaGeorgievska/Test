package com.example.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.book.entity.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	// а) Сите книги (Ebooks,PrintCopy) по хронолошки редослед почнувајќи од најстарата (година на издавање)
	//@Query("FROM Book b ORDER BY b.releasedYear ASC")
	
	// б) Сите Книги од Автор чие презиме почнува на дадена буква (дадената буква ќе биде некаков влез (input) во апликацијата)
	@Query("SELECT b FROM Book b WHERE b.author.surname LIKE %?1%")

	//г) Сите Автори кои имаат напишано повеќе од 3 книги
	//@Query("SELECT b.author.name, b.author.surname FROM Book b GROUP BY b.author.name, b.author.surname HAVING(COUNT(b.author.name))>3 ")
	
	//д) Да се најде најстара и најнова книга /ПОКАЖУВА ГРЕШКА
	//@Query("SELECT b FROM Book b ORDER BY b.released_Year ASC LIMIT 1")
	
	
	// в) Сите Автори за кои имаме Книги кои биле испечатени во иста Декада кога авторот се родил.
	//@Query("SELECT b FROM Book b WHERE b.releasedYear BETWEEN b.author.birthYear AND (b.author.birthYear) + 10 ")
	
	
	List<Book> search (@Param("keyword") String keyword);
	
	
	
}