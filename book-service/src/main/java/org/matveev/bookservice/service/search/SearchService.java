package org.matveev.bookservice.service.search;

import org.matveev.bookservice.domain.entity.Book;

public interface SearchService {

    Book search(String isbn);
}
