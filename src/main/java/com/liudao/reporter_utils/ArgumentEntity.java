package com.liudao.reporter_utils;

public class ArgumentEntity {
    private String val;
    private String offset;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "ArgumentEntity{" +
                "val='" + val + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
