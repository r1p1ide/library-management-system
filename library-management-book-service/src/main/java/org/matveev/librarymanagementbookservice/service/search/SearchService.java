package org.matveev.librarymanagementbookservice.service.search;

import org.matveev.librarymanagementbookservice.domain.entity.Book;

public interface SearchService {

    Book search(String isbn);
}
