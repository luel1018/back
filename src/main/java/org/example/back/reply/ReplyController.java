package org.example.spring02.reply;

import lombok.RequiredArgsConstructor;
import org.example.spring02.reply.model.ReplyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reg/{boardIdx}")
    public ResponseEntity register(@RequestBody ReplyDto.Reg dto, @PathVariable int boardIdx) {

        replyService.register(dto, boardIdx);

        return ResponseEntity.ok("성공");
    }
}
