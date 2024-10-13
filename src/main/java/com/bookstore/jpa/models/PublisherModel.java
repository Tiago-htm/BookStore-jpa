package com.bookstore.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name = "TB_PUBLISH") //
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L; // Não é necessário criar metódo

    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String nameEditora;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // apenas para escrita, para não dar erro de serialização
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY) // Lazy significa que só vamos chamar essa registro da
                                                               // chave estrangeira quando necessário // o Tipo EAger
                                                               // ele é carregamento rapido mas pode carregar dados atoa
    private Set<BookModel> books = new HashSet<>();

    public PublisherModel() {
        this.id = UUID.randomUUID(); // VAI GERAR OS IDS
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameEditora() {
        return nameEditora;
    }

    public void setNameEditora(String nameEditora) {
        this.nameEditora = nameEditora;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }

}
