package org.matveev.bookservice.grpc.converter.impl;

import org.matveev.bookservice.domain.dto.GetResponseDto;
import org.matveev.bookservice.domain.dto.SearchResponseDto;
import org.matveev.bookservice.grpc.converter.DtoToProtoConverter;
import org.matveev.bookservice.proto.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoToProtoConverterImpl implements DtoToProtoConverter {

    @Override
    public GetResponse convert(GetResponseDto dto) {
        return GetResponse.newBuilder()
                .setId(dto.getId())
                .setTitle(dto.getTitle())
                .setAuthor(dto.getAuthor())
                .setIsbn(dto.getIsbn())
                .setCopies(dto.getCopies())
                .build();
    }

    @Override
    public SearchResponse convert(SearchResponseDto dto) {
        List<Book> protoBooks = new ArrayList<>();
        for (org.matveev.bookservice.domain.entity.Book dtoBook : dto.getBooks()) {
            protoBooks.add(convert(dtoBook));
        }

        return SearchResponse.newBuilder()
                .addAllBooks(protoBooks)
                .build();
    }

    @Override
    public Book convert(org.matveev.bookservice.domain.entity.Book book) {
        return Book.newBuilder()
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor())
                .setIsbn(book.getIsbn())
                .setCopies(book.getCopies())
                .build();
    }

}
