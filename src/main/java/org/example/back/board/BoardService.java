package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void register(BoardDto.Reg dto, String writerEmail) {
        boardRepository.register(dto, writerEmail);
    }

    public BoardDto.Read read(int idx) {
        return boardRepository.read(idx);
    }

    public List<BoardDto.Read> list() {
        return boardRepository.list();
    }

    public boolean update(int idx, BoardDto.Update dto, String writerEmail) {
        return boardRepository.update(idx, dto, writerEmail) > 0;
    }

    public boolean delete(int idx, String writerEmail) {
        return boardRepository.delete(idx, writerEmail) > 0;
    }
}