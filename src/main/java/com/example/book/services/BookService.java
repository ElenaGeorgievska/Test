package com.example.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	
	// search book
		public List<Book> searchBooksByQuery(String keyword) {

			if (keyword != null) {
				return bookRepo.search(keyword);
			}
			return bookRepo.findAll();
		}
	
	
	// paging and sorting
		public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
			Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
					: Sort.by(sortField).descending();

			Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
			return this.bookRepo.findAll(pageable);
		}
}

