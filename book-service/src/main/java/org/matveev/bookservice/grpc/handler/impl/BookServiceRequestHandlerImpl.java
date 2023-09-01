package org.matveev.bookservice.grpc.handler.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.bookservice.grpc.converter.DtoToProtoConverter;
import org.matveev.bookservice.grpc.converter.ProtoToDtoConverter;
import org.matveev.bookservice.grpc.handler.BookServiceRequestHandler;
import org.matveev.bookservice.proto.*;
import org.matveev.bookservice.service.BookService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookServiceRequestHandlerImpl implements BookServiceRequestHandler {

    private final BookService bookService;
    private final ProtoToDtoConverter protoToDtoConverter;
    private final DtoToProtoConverter dtoToProtoConverter;

    @Override
    public void handleRequest(AddRequest request) {
        bookService.save(
                protoToDtoConverter.convert(request)
        );
    }

    @Override
    public void handleRequest(DeleteRequest request) {
        bookService.delete(
                protoToDtoConverter.convert(request)
        );
    }

    @Override
    public void handleRequest(UpdateRequest request) {
        bookService.update(
                protoToDtoConverter.convert(request)
        );
    }

    @Override
    public GetResponse handleRequest(GetRequest request) {
        return dtoToProtoConverter.convert(
                bookService.get(
                        protoToDtoConverter.convert(request)
                )
        );
    }

    @Override
    public SearchResponse handleRequest(SearchRequest request) {
        return dtoToProtoConverter.convert(
                bookService.search(
                        protoToDtoConverter.convert(request)
                )
        );
    }

}
