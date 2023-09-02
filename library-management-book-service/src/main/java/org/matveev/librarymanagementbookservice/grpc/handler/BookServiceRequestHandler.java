package org.matveev.librarymanagementbookservice.grpc.handler;

import org.matveev.librarymanagementbookservice.proto.AddRequest;
import org.matveev.librarymanagementbookservice.proto.DeleteRequest;
import org.matveev.librarymanagementbookservice.proto.GetResponse;
import org.matveev.librarymanagementbookservice.proto.GetRequest;
import org.matveev.librarymanagementbookservice.proto.SearchResponse;
import org.matveev.librarymanagementbookservice.proto.SearchRequest;
import org.matveev.librarymanagementbookservice.proto.UpdateRequest;

public interface BookServiceRequestHandler {

    void handleRequest(AddRequest request);

    void handleRequest(DeleteRequest request);

    void handleRequest(UpdateRequest request);

    GetResponse handleRequest(GetRequest request);

    SearchResponse handleRequest(SearchRequest request);
}
