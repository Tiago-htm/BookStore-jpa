package com.bookstore.jpa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository; //oferece suporte para CRUD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.jpa.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

    BookModel findBookModelByTitle(String title); // define a busca para buscar la no banco de dados da coluna titulo

    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true) // retornar todos os livros
                                                                                         // publicados
    List<BookModel> findBookModelByPublisherId(@Param("id") UUID id);

}
