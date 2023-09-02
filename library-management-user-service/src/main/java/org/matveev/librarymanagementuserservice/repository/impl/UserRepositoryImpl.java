package org.matveev.librarymanagementuserservice.repository.impl;

import lombok.RequiredArgsConstructor;
import org.matveev.librarymanagementuserservice.domain.entity.User;
import org.matveev.librarymanagementuserservice.repository.UserRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void save(User user) {
        namedParameterJdbcTemplate.update(
                "INSERT INTO users (id, name, email, password_hash, date_joined) " +
                        "VALUES (DEFAULT, :name, :email, :password_hash, :date_joined)",
                new MapSqlParameterSource()
                        .addValue("name", user.getName())
                        .addValue("email", user.getEmail())
                        .addValue("password_hash", user.getPassword_hash())
                        .addValue("date_joined", user.getDate_joined())
        );
    }

    @Override
    public void delete(long id) {
        namedParameterJdbcTemplate.update(
                "DELETE FROM users WHERE id=:id",
                new MapSqlParameterSource()
                        .addValue("id", id)
        );
    }

    @Override
    public void update(User user) {
        namedParameterJdbcTemplate.update(
                "UPDATE users SET " +
                        "name=:name, " +
                        "email=:email, " +
                        "password_hash=:password_hash, " +
                        "date_joined=:date_joined " +
                        "WHERE email=:email",
                new MapSqlParameterSource()
                        .addValue("name", user.getName())
                        .addValue("email", user.getEmail())
                        .addValue("password_hash", user.getPassword_hash())
                        .addValue("date_joined", user.getDate_joined())
        );
    }

}
