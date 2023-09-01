package org.matveev.bookservice.exception;

public class SearchTypeNotFoundException extends RuntimeException {

    public SearchTypeNotFoundException(String message) {
        super(message);
    }

}
