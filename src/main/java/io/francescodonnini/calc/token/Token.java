package io.francescodonnini.calc.token;

public class Token {
    private final int position;

    public Token(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
