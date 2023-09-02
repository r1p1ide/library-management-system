package org.matveev.librarymanagementbookservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.matveev.librarymanagementbookservice.domain.dto.*;
import org.matveev.librarymanagementbookservice.domain.entity.Book;
import org.matveev.librarymanagementbookservice.exception.BookNotFoundException;
import org.matveev.librarymanagementbookservice.repository.BookRepository;
import org.matveev.librarymanagementbookservice.service.BookService;
import org.matveev.librarymanagementbookservice.service.converter.BookConverter;
import org.matveev.librarymanagementbookservice.service.search.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookConverter converter;
    private final SearchService searchService;

    @Override
    @Transactional
    public void save(AddRequestDto dto) {
        log.info("Start ADD process. Input: entity={}", dto);

        var book = converter.convert(dto);

        var desiredBook = searchService.search(book.getIsbn());

        if (desiredBook != null) {
            book.setCopies(desiredBook.getCopies() + book.getCopies());
            bookRepository.update(book);
        } else {
            bookRepository.add(book);
        }
        log.info("End ADD process.");
    }

    @Override
    @Transactional
    public void delete(DeleteRequestDto dto) {
        var id = dto.getId();
        log.info("Start DELETE process. Input: id={}", id);

        try {
            bookRepository.get(id);
            bookRepository.delete(id);
        } catch (Exception e) {
            throw new BookNotFoundException("Book with id=" + id + " doesn't found in the database");
        }

        log.info("End DELETE process");
    }

    @Override
    @Transactional
    public void update(UpdateRequestDto dto) {
        log.info("Start UPDATE process. Input: entity={}", dto);

        bookRepository.update(
                converter.convert(dto)
        );

        log.info("End UPDATE process");
    }

    @Override
    public GetResponseDto get(GetRequestDto dto) {
        log.info("Start GET process. Input: entity={}", dto);

        Book book;
        try {
            book = bookRepository.get(dto.getId());
        } catch (Exception e) {
            throw new BookNotFoundException("Book with id=" + dto.getId() + " doesn't found in the database");
        }

        var response = converter.convert(book);

        log.info("End GET process. Output: GetResponseDto={}", response);

        return response;
    }

    @Override
    public SearchResponseDto search(SearchRequestDto dto) {
        log.info("Start SEARCH process. Input: entity={}", dto);

        var response = bookRepository.search(dto);

        log.info("End SEARCH process. Output: SearchResponseDto={}", response);

        return response;
    }

}
