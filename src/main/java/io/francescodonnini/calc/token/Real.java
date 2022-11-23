package io.francescodonnini.calc.token;

public class Real extends Token {
    private final double value;

    public Real(double value, int position) {
        super(position);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%f, %d)", getValue(), getPosition());
    }

    public double getValue() {
        return value;
    }
}
