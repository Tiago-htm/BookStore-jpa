package com.bookstore.jpa.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.HashSet;

import java.util.UUID;

@Entity
@Table(name = "TB_BOOK") // tabela
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L; // Não é necessário criar metódo

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO) // gerecao de id automatico
    // mas esta em desuso
    private UUID id;
    @Column(nullable = false, unique = true) // nullable titulo é obrigatório e titulos iguais
    private String title;

    @ManyToOne // Muitos livros para uma editora
    @JoinColumn(name = "publisher_id") // chave estrangeira de publicação
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(name = "tb_book_author", // tabela auxiliar
            joinColumns = @JoinColumn(name = "book_id"), // chaves primaria e ao mesmo tempo chave estrangeira do outro
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorModel> authors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL) // cascada para pegar todos os review vinculados ao book
    private ReviewModel review;

    public BookModel() {
        this.id = UUID.randomUUID(); // VAI GERAR OS IDS
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

}
