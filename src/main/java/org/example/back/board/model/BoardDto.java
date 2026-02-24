package org.example.spring02.board.model;

import lombok.*;
import org.example.spring02.reply.model.ReplyDto;

import java.util.List;

public class BoardDto {
    @Getter
    public static class Reg {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Res {
        private Long idx;
        private String title;
        private String contents;
        private List<ReplyDto.Read> replyList;

        public static Res from(Board entity) {
            return Res.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
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
