package org.example.back.db;

public class DbDto {
    private String var01;
    private int var02;

    public DbDto() {
    }

    public DbDto(String var01, int var02) {
        this.var01 = var01;
        this.var02 = var02;
    }

    public String getVar01() {
        return var01;
    }

    public void setVar01(String var01) {
        this.var01 = var01;
    }

    public int getVar02() {
        return var02;
    }

    public void setVar02(int var02) {
        this.var02 = var02;
    }
}
