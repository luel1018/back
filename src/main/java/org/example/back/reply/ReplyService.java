package org.example.spring02.reply;

import lombok.RequiredArgsConstructor;
import org.example.spring02.reply.model.ReplyDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void register(ReplyDto.Reg dto, int boardIdx) {
        replyRepository.save(dto, boardIdx);
    }
}
