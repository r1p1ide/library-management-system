package org.matveev.librarymanagementbookservice.grpc.converter.impl;

import org.matveev.librarymanagementbookservice.domain.dto.GetResponseDto;
import org.matveev.librarymanagementbookservice.domain.dto.SearchResponseDto;
import org.matveev.librarymanagementbookservice.grpc.converter.DtoToProtoConverter;
import org.springframework.stereotype.Component;
import org.matveev.librarymanagementbookservice.proto.Book;
import org.matveev.librarymanagementbookservice.proto.GetResponse;
import org.matveev.librarymanagementbookservice.proto.SearchResponse;

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
        for (org.matveev.librarymanagementbookservice.domain.entity.Book dtoBook : dto.getBooks()) {
            protoBooks.add(convert(dtoBook));
        }

        return SearchResponse.newBuilder()
                .addAllBooks(protoBooks)
                .build();
    }

    @Override
    public Book convert(org.matveev.librarymanagementbookservice.domain.entity.Book book) {
        return Book.newBuilder()
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor())
                .setIsbn(book.getIsbn())
                .setCopies(book.getCopies())
                .build();
    }

}
