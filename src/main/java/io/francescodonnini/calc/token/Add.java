package io.francescodonnini.calc.token;

public class Add extends Token {
    public Add(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return String.format("(\"+\", %d)", getPosition());
    }
}
