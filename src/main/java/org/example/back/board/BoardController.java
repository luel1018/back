package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/reg")
    public ResponseEntity register(@RequestBody BoardDto.Reg dto) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable int idx) {
        BoardDto.Read dto = boardService.read(idx);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<BoardDto.Read> dto = boardService.list();
        return ResponseEntity.ok(dto);
    }
}
