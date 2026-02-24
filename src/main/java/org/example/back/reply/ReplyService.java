package org.example.back.reply;

import lombok.RequiredArgsConstructor;
import org.example.back.reply.model.ReplyDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void register(ReplyDto.Reg dto, int boardIdx) {
        replyRepository.save(dto, boardIdx);
    }
}
