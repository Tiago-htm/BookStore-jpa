package com.bookstore.jpa.service;

import com.bookstore.jpa.dtos.BookRecordDtos;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.ReviewModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
            PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional // para preservar os dados caso der algum errro acontece um rollback
    public BookModel saveBook(BookRecordDtos bookRecordDtos) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDtos.title());
        book.setPublisher(publisherRepository.findById(bookRecordDtos.publisher_id()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDtos.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setcoment(bookRecordDtos.reviewComent());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

}
