package org.example.back.board.model;

import lombok.*;
import org.example.back.reply.model.ReplyDto;

import java.util.List;

public class BoardDto {
    @Getter
    public static class Reg {
        private String title;
        private String contents;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Res {
        private int idx;
        private String title;
        private String contents;
        private List<ReplyDto.Read> replyList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Read {
        private int idx;
        private String title;
        private String contents;
        private int ridx;
        private String rcontents;

    }
}
