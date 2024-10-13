package com.bookstore.jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.jpa.models.BookModel;

public interface AuthorRepository extends JpaRepository<BookModel, UUID> {

}
