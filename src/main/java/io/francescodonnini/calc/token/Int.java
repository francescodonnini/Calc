package io.francescodonnini.calc.token;

public class Int extends Token {
    private final int value;

    public Int(int value, int position) {
        super(position);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", value, getPosition());
    }

    public int getValue() {
        return value;
    }
}
