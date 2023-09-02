package org.matveev.librarymanagementuserservice.repository;

import org.matveev.librarymanagementuserservice.domain.entity.User;

public interface UserRepository {

    void save(User user);

    void delete(long id);

    void update(User user);
}
