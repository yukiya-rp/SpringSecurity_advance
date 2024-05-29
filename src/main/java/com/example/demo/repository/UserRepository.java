package com.example.demo.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserRepository {

  @Autowired
  private NamedParameterJdbcTemplate template;

  private RowMapper<User> USER_ROW_MAPPER = (rs, row) -> new User(
      rs.getInt("id"),
      rs.getString("username"),
      rs.getString("password"),
      rs.getString("role"));

  public Optional<User> findByUsername(String username) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("username", username);
    String sql = "SELECT * FROM users WHERE username = :username";

    return Optional.ofNullable(template.queryForObject(sql, param, USER_ROW_MAPPER));
  }
}
