package org.example.back.board.model;

public class BoardDto {
    public static class Reg {
        private String title;
        private String contents;

        public Reg() {
        }

        public Reg(String title, String contents) {
            this.title = title;
            this.contents = contents;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }
    }

    public static class Read {
        private int idx;
        private String title;
        private String contents;

        public Read() {
        }

        public Read(int idx, String title, String contents) {
            this.idx = idx;
            this.title = title;
            this.contents = contents;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }
    }
}
