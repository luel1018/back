package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void register(BoardDto.Reg dto, String writerEmail) {
        jdbcTemplate.update(
                "INSERT INTO board (title, contents, writer) VALUES (?, ?, ?)",
                dto.getTitle(),
                dto.getContents(),
                writerEmail
        );
    }

    public BoardDto.Read read(int idx) {
        return jdbcTemplate.queryForObject(
                "SELECT idx, title, contents FROM board WHERE idx=?",
                new BeanPropertyRowMapper<>(BoardDto.Read.class),
                idx
        );
    }

    public List<BoardDto.Read> list() {
        return jdbcTemplate.query(
                "SELECT idx, title, contents FROM board ORDER BY idx DESC",
                new BeanPropertyRowMapper<>(BoardDto.Read.class)
        );
    }

    public int update(int idx, BoardDto.Update dto, String writerEmail) {
        return jdbcTemplate.update(
                "UPDATE board SET title=?, contents=? WHERE idx=? AND writer=?",
                dto.getTitle(),
                dto.getContents(),
                idx,
                writerEmail
        );
    }

    public int delete(int idx, String writerEmail) {
        return jdbcTemplate.update(
                "DELETE FROM board WHERE idx=? AND writer=?",
                idx,
                writerEmail
        );
    }
}