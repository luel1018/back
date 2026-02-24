package org.example.back.reply;

import lombok.RequiredArgsConstructor;
import org.example.back.reply.model.ReplyDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReplyRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(ReplyDto.Reg dto, int boardIdx) {
        jdbcTemplate.update(
                "INSERT INTO reply (contents, boardIdx) VALUE (?, ?)",
                dto.getContents(), boardIdx
        );


    }
}
