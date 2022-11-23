package io.francescodonnini.calc.token;

public class Ident extends Token {
    private final String name;

    public Ident(String name, int position) {
        super(position);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("(\"%s\", %d)", getName(), getPosition());
    }

    public String getName() {
        return name;
    }
}
