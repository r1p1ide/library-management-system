package org.matveev.librarymanagementbookservice.service.converter.impl;

import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.domain.entity.Book;
import org.matveev.librarymanagementbookservice.service.converter.BookConverter;
import org.springframework.stereotype.Component;

@Component
public class BookConverterImpl implements BookConverter {

    @Override
    public Book convert(AddRequestDto dto) {
        return Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .copies(dto.getCopies())
                .build();
    }

    @Override
    public Book convert(UpdateRequestDto dto) {
        return Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .copies(dto.getCopies())
                .build();
    }

    @Override
    public GetResponseDto convert(Book book) {
        return GetResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .build();
    }

}
