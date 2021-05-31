package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book.entity.BookTypes;

@Repository
public interface BookTypesRepository extends JpaRepository<BookTypes, Integer>  {

}
