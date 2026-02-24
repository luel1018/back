package org.example.back.reply.model;

import lombok.*;

public class ReplyDto {
    @Getter
    @Builder
    public static class Reg {
        private String contents;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Read {
        private int idx;
        private String contents;
    }
}
