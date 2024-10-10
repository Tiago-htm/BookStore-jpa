package com.bookstroe.jpa.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_REVIL")

public class RevilModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @Column(nullable = false) //
    private String coment;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    public RevilModel() {
        this.id = UUID.randomUUID(); // VAI GERAR OS IDS
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getcoment() {
        return coment;
    }

    public void setcoment(String coment) {
        this.coment = coment;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

}
