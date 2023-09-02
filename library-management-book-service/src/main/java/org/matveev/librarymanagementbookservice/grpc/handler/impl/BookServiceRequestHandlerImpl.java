package org.matveev.librarymanagementbookservice.grpc.handler.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.librarymanagementbookservice.grpc.converter.DtoToProtoConverter;
import org.matveev.librarymanagementbookservice.grpc.converter.ProtoToDtoConverter;
import org.matveev.librarymanagementbookservice.grpc.handler.BookServiceRequestHandler;
import org.matveev.librarymanagementbookservice.service.BookService;
import org.springframework.stereotype.Component;
import org.matveev.librarymanagementbookservice.proto.GetResponse;
import org.matveev.librarymanagementbookservice.proto.GetRequest;
import org.matveev.librarymanagementbookservice.proto.SearchResponse;
import org.matveev.librarymanagementbookservice.proto.SearchRequest;
import org.matveev.librarymanagementbookservice.proto.UpdateRequest;

@Component
@RequiredArgsConstructor
public class BookServiceRequestHandlerImpl implements BookServiceRequestHandler {

    private final BookService bookService;
    private final ProtoToDtoConverter protoToDtoConverter;
    private final DtoToProtoConverter dtoToProtoConverter;

    @Override
    public void handleRequest(org.matveev.librarymanagementbookservice.proto.AddRequest request) {
        bookService.save(
                protoToDtoConverter.convert(request)
        );
    }

    @Override
    public void handleRequest(org.matveev.librarymanagementbookservice.proto.DeleteRequest request) {
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
