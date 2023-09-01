package org.matveev.bookservice.grpc.server;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.matveev.bookservice.grpc.handler.impl.BookServiceRequestHandlerImpl;
import org.matveev.bookservice.proto.*;

@GrpcService
@RequiredArgsConstructor
public class BookServiceGrpcImpl extends BookServiceGrpc.BookServiceImplBase {

    private final BookServiceRequestHandlerImpl requestHandler;

    @Override
    public void add(AddRequest request, StreamObserver<Empty> responseObserver) {
        try {
            requestHandler.handleRequest(request);
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void delete(DeleteRequest request, StreamObserver<Empty> responseObserver) {
        try {
            requestHandler.handleRequest(request);
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void update(UpdateRequest request, StreamObserver<Empty> responseObserver) {
        try {
            requestHandler.handleRequest(request);
            responseObserver.onNext(Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        try {
            var response = requestHandler.handleRequest(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void search(SearchRequest request, StreamObserver<SearchResponse> responseObserver) {
        try {
            var searchResponse = requestHandler.handleRequest(request);
            responseObserver.onNext(searchResponse);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription(e.getMessage())
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

}
