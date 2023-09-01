package org.matveev.bookservice.grpc.converter.impl;

import org.matveev.bookservice.domain.SearchType;
import org.matveev.bookservice.domain.dto.*;
import org.matveev.bookservice.grpc.converter.ProtoToDtoConverter;
import org.matveev.bookservice.proto.*;
import org.springframework.stereotype.Component;

@Component
public class ProtoToDtoConverterImpl implements ProtoToDtoConverter {

    @Override
    public AddRequestDto convert(AddRequest request) {
        var book = request.getBook();
        return AddRequestDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .copies(book.getCopies())
                .build();
    }

    @Override
    public DeleteRequestDto convert(DeleteRequest request) {
        return DeleteRequestDto.builder()
                .id(request.getId())
                .build();
    }

    @Override
    public UpdateRequestDto convert(UpdateRequest request) {
        var book = request.getBook();
        return UpdateRequestDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .copies(book.getCopies())
                .build();
    }

    @Override
    public GetRequestDto convert(GetRequest request) {
        return GetRequestDto.builder()
                .id(request.getId())
                .build();
    }

    @Override
    public SearchRequestDto convert(SearchRequest request) {
        return SearchRequestDto.builder()
                .query(request.getQuery())
                .searchType(SearchType.valueOf(request.getSearchType().name()))
                .build();
    }

}
