package com.myphrase;

class Phrase {
    private int id;
    private String writer;
    private String phrase;

    public Phrase(int id, String writer, String phrase) {
        this.id = id;
        this.writer = writer;
        this.phrase = phrase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
