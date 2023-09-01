package org.matveev.bookservice.service.converter.impl;

import org.matveev.bookservice.domain.dto.*;
import org.matveev.bookservice.domain.entity.Book;
import org.matveev.bookservice.service.converter.BookConverter;
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
