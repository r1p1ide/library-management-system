package org.matveev.bookservice.repository;

import org.matveev.bookservice.domain.dto.SearchRequestDto;
import org.matveev.bookservice.domain.dto.SearchResponseDto;
import org.matveev.bookservice.domain.entity.Book;

public interface BookRepository {

    void add(Book book);

    void delete(long id);

    void update(Book book);

    Book get(long id);

    SearchResponseDto search(SearchRequestDto dto);
}
