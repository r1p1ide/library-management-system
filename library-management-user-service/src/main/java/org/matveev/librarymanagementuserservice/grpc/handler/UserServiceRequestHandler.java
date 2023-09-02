package org.matveev.librarymanagementuserservice.grpc.handler;

import org.matveev.librarymanagementuserservice.proto.DeleteRequest;
import org.matveev.librarymanagementuserservice.proto.RegisterRequest;
import org.matveev.librarymanagementuserservice.proto.UpdateRequest;

public interface UserServiceRequestHandler {

    void handleRequest(RegisterRequest request);

    void handleRequest(DeleteRequest request);

    void handleRequest(UpdateRequest request);
}
