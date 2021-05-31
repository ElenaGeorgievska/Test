package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.book.entity.Author;
import com.example.book.entity.Book;
import com.example.book.entity.BookTypes;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.repository.BookTypesRepository;
import com.example.book.services.BookService;




@Controller
public class BookController {
	
	@Autowired
	AuthorRepository authorRepo;

    @Autowired
    BookRepository bookRepo;
    
    @Autowired
	private BookService bookService;
    
    @Autowired
    BookTypesRepository bookTypesRepo;
	
 
  	
 // get all books with search functions from TASK 2, we choose certain function from BookRepository
  	@GetMapping("/books")
  	public String viewBooks(Model model, @Param("keyword") String keyword) {
  		
  		findPaginated(1, "title", "asc", model);

  		//List<Book> listBooks = bookRepo.findAll(); // get list of Books
  
  		List<Book> listBooks = bookService.searchBooksByQuery(keyword);
  		
  		model.addAttribute("listBooks", listBooks);
  		model.addAttribute("keyword", keyword);
  	

  		return "books/booksList_home";
  	
  	}
 
	/*
 // get all books without search function
 	@GetMapping("/books")
 	public String viewBooks(Model model, @Param("keyword") String keyword) {
 		
 		findPaginated(1, "title", "asc", model);

 		List<Book> listBooks = bookRepo.findAll(); // get list of Books
 		
 		model.addAttribute("listBooks", listBooks);
 		model.addAttribute("keyword", keyword);
 	

 		return "books/booksList_home";
 	
 	} */
 	
 	

 	// create book
 	@PostMapping("/books/add")
 	public String createBook(@ModelAttribute("book") Book book) {

 		bookRepo.save(book);

 		return "redirect:/books";

 	}

 	// new book form
 	@GetMapping("/books/showNewBookForm")
 	public String showNewBookForm(Model model) {

 		Book book = new Book(); // creating object for the form
 		model.addAttribute("book", book);
 		
 		List<Author> listAuthors = authorRepo.findAll(); // get list of authors
 		model.addAttribute("listAuthors", listAuthors);
 		
 		List<BookTypes> listBookTypes = bookTypesRepo.findAll();
 		model.addAttribute("listBookTypes", listBookTypes);
 		

 		return "books/new_bookForm";
 	}
 	
 	
 	// show form for update book
 	@GetMapping("/books/showUpdateBookForm/{id}")
 	public String showUpdateBookForm(@PathVariable(value = "id") Integer id, Model model) {

 		Book book = bookRepo.findById(id).get();
 		model.addAttribute("book", book);
 		
 		
 		List<Author> listAuthors = authorRepo.findAll(); // get list of authors
 		model.addAttribute("listAuthors", listAuthors);
 		
 		List<BookTypes> listBookTypes = bookTypesRepo.findAll(); //get list of book types
 		model.addAttribute("listBookTypes", listBookTypes);
 		
 		return "books/updateBook";
 	}

 	// update book
 	@PostMapping("/books/updateBook")
 	public String updateBook(@ModelAttribute("book") Book book) {

 		bookRepo.save(book);

 		return "redirect:/books";

 	}
    

 	// delete Book
 	@GetMapping("/books/deleteBook/{id}")
 	public String deleteBook(@PathVariable("id") Integer id) {
 		bookRepo.deleteById(id);

 		return "redirect:/books";

 	}
 	
 	
 	
 	//paging and sorting
 			@GetMapping("/page/{pageNo}")
 			public String findPaginated(@PathVariable (value = "pageNo") Integer pageNo, 
 					@RequestParam("sortField") String sortField,
 					@RequestParam("sortDir") String sortDir,
 					Model model) {
 				Integer pageSize = 5;
 				
 				Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
 				List<Book> listBooks = page.getContent();
 				
 				model.addAttribute("currentPage", pageNo);
 				model.addAttribute("totalPages", page.getTotalPages());
 				model.addAttribute("totalItems", page.getTotalElements());
 				
 				model.addAttribute("sortField", sortField);
 				model.addAttribute("sortDir", sortDir);
 				model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
 				
 				model.addAttribute("listBooks", listBooks);
 				
 				
 				return "books/booksList_home";
 				
 				
 			}
 			
 			
 			
 			
 }





