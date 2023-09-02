package org.matveev.librarymanagementbookservice.repository;

import org.matveev.librarymanagementbookservice.domain.dto.SearchRequestDto;
import org.matveev.librarymanagementbookservice.domain.dto.SearchResponseDto;
import org.matveev.librarymanagementbookservice.domain.entity.Book;

public interface BookRepository {

    void add(Book book);

    void delete(long id);

    void update(Book book);

    Book get(long id);

    SearchResponseDto search(SearchRequestDto dto);
}
