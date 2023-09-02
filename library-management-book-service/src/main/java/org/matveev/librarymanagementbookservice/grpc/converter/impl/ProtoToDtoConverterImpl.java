package org.matveev.librarymanagementbookservice.grpc.converter.impl;

import org.matveev.librarymanagementbookservice.domain.SearchType;
import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.grpc.converter.ProtoToDtoConverter;
import org.springframework.stereotype.Component;
import org.matveev.librarymanagementbookservice.proto.AddRequest;
import org.matveev.librarymanagementbookservice.proto.DeleteRequest;
import org.matveev.librarymanagementbookservice.proto.GetRequest;
import org.matveev.librarymanagementbookservice.proto.SearchRequest;
import org.matveev.librarymanagementbookservice.proto.UpdateRequest;

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
