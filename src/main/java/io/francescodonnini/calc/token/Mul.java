package io.francescodonnini.calc.token;

public class Mul extends Token {
    public Mul(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return String.format("(\"*\", %d)", getPosition());
    }
}
