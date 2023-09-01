package org.matveev.bookservice.grpc.handler;

import org.matveev.bookservice.proto.*;

public interface BookServiceRequestHandler {

    void handleRequest(AddRequest request);

    void handleRequest(DeleteRequest request);

    void handleRequest(UpdateRequest request);

    GetResponse handleRequest(GetRequest request);

    SearchResponse handleRequest(SearchRequest request);
}
