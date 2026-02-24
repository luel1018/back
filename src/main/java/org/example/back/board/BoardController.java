package org.example.back.board;

import org.example.back.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
        String writerEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        boardService.register(dto, writerEmail);
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

    @PutMapping("/update/{idx}")
    public ResponseEntity update(@PathVariable int idx, @RequestBody BoardDto.Update dto) {
        String writerEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean ok = boardService.update(idx, dto, writerEmail);

        if (!ok) {
            return ResponseEntity.status(403).body("권한 없거나 게시글이 없음");
        }
        return ResponseEntity.ok("성공");
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity delete(@PathVariable int idx) {
        String writerEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean ok = boardService.delete(idx, writerEmail);

        if (!ok) {
            return ResponseEntity.status(403).body("권한 없거나 게시글이 없음");
        }
        return ResponseEntity.ok("성공");
    }
}