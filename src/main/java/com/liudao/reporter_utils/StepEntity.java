package com.liudao.reporter_utils;

public class StepEntity {
    private int line;
    private ResultEntity result;
    private String name;
    private MatchEntity match;
    private String keyword;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MatchEntity getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match = match;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "StepEntity{" +
                "line=" + line +
                ", result=" + result +
                ", name='" + name + '\'' +
                ", match=" + match +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
