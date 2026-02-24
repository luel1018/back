package org.example.back.board;

import lombok.RequiredArgsConstructor;
import org.example.back.board.model.Board;
import org.example.back.board.model.BoardDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;


    public void register(BoardDto.Reg dto) {
        boardRepository.save(dto.toEntity());
    }

    public BoardDto.Res read(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow(
                () -> new RuntimeException()
        );
//        Optional<Board> result = boardRepository.findById(idx);
//
//        if(result.isPresent()) {
//            Board board = result.get();
//
//            return BoardDto.Res.from(board); // dto로 변환
//        } else {
//        }
        return BoardDto.Res.from(board);
    }

    public List<BoardDto.Res> list() {
        List<Board> boardList = boardRepository.findAll();
//        List<BoardDto.Res> dtoList = new ArrayList<>();
//
//        for (Board board : boardList) {
//            dtoList.add(BoardDto.Res.from(board));
//        }

        return boardList.stream().map(BoardDto.Res::from).toList();
    }
}
