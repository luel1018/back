package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void register(BoardDto.Reg dto) {
        boardRepository.register(dto);
    }

    public BoardDto.Read read(int idx) {
        return boardRepository.read(idx);
    }

    public List<BoardDto.Read> list() {
        return boardRepository.list();
    }
}
