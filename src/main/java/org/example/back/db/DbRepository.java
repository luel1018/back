package org.example.back.db;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbRepository {
    private final JdbcTemplate jdbcTemplate;

    public DbRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(DbDto dto) {
        // INSERT, UPDATE, DELETE
        jdbcTemplate.update("INSERT INTO qwer (var01, var02) VALUES (?, ?)", dto.getVar01(), dto.getVar02());
    }

    public DbDto read(int idx){

        // SELECT 결과가 1개일 때
        DbDto dto = jdbcTemplate.queryForObject(
                "SELECT * FROM qwer WHERE idx=?",
                new BeanPropertyRowMapper<>(DbDto.class),
                idx
        ); //알아서 DTO로 변환까지!
        return dto;
    }

    public List<DbDto> list() {
        // SELECT 결과가 여러개일 때
        List<DbDto> dtoList = jdbcTemplate.query(
                "SELECT * FROM qwer",
                new BeanPropertyRowMapper<>(DbDto.class)
        );

        return dtoList;
    }

}
