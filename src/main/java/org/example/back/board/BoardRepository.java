package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.example.back.db.DbDto;
import org.example.back.user.model.LoginResDto;
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

    public void register(BoardDto.Reg dto) {
        jdbcTemplate.update("INSERT INTO board (title, contents) VALUES (?, ?)",
                dto.getTitle(),
                dto.getContents()
        );
    }

    public BoardDto.Read read(int idx) {
        BoardDto.Read result = jdbcTemplate.queryForObject(
                "SELECT * FROM board WHERE idx=?",
                new BeanPropertyRowMapper<>(BoardDto.Read.class),
                idx
        ); //알아서 DTO로 변환까지!
        return result;
    }

    public List<BoardDto.Read> list() {// SELECT 결과가 여러개일 때
        List<BoardDto.Read> dtoList = jdbcTemplate.query(
                "SELECT * FROM board",
                new BeanPropertyRowMapper<>(BoardDto.Read.class)
        );

        return dtoList;
    }
}
