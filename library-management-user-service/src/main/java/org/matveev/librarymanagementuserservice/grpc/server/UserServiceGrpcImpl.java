package org.matveev.librarymanagementuserservice.grpc.server;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.matveev.librarymanagementuserservice.grpc.handler.UserServiceRequestHandler;
import org.matveev.librarymanagementuserservice.proto.DeleteRequest;
import org.matveev.librarymanagementuserservice.proto.LibraryManagementUserServiceGrpc.LibraryManagementUserServiceImplBase;
import org.matveev.librarymanagementuserservice.proto.RegisterRequest;
import org.matveev.librarymanagementuserservice.proto.UpdateRequest;

import java.util.function.Consumer;

@GrpcService
@RequiredArgsConstructor
public class UserServiceGrpcImpl extends LibraryManagementUserServiceImplBase {

    private final UserServiceRequestHandler requestHandler;

    private <T> void handleRequest(T request, StreamObserver<Empty> responseObserver, Consumer<T> handler) {
        try {
            handler.accept(request);
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
    public void register(RegisterRequest request, StreamObserver<Empty> responseObserver) {
        handleRequest(request, responseObserver, requestHandler::handleRequest);
    }

    @Override
    public void delete(DeleteRequest request, StreamObserver<Empty> responseObserver) {
        handleRequest(request, responseObserver, requestHandler::handleRequest);
    }

    @Override
    public void update(UpdateRequest request, StreamObserver<Empty> responseObserver) {
        handleRequest(request, responseObserver, requestHandler::handleRequest);
    }

}
