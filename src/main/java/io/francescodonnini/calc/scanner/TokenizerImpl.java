package io.francescodonnini.calc.scanner;

import io.francescodonnini.calc.error.InvalidInput;
import io.francescodonnini.calc.token.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TokenizerImpl implements Tokenizer {
    private final String source;
    private int readPos;

    public TokenizerImpl(String source) {
        this.source = source;
        readPos = 0;
    }

    public Iterator<Token> tokenize() throws InvalidInput {
        List<Token> tokens = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        while (true) {
            while (hasNext() && Character.isSpaceChar(getChar())) {
                nextChar();
            }
            if (!hasNext()) {
                return tokens.stream().iterator();
            }
            if (Character.isAlphabetic(getChar())) {
                int startPos = readPos;
                s.append(getChar());
                nextChar();
                while (hasNext() && Character.isAlphabetic(getChar())) {
                    s.append(getChar());
                    nextChar();
                }
                tokens.add(new Ident(s.toString(), startPos));
                s.setLength(0);
            } else if (Character.isDigit(getChar())) {
                int startPos = readPos;
                s.append(getChar());
                nextChar();
                while (hasNext() && Character.isDigit(getChar())) {
                    s.append(getChar());
                    nextChar();
                }
                if (hasNext() && getChar() == '.') {
                    s.append(getChar());
                    nextChar();
                    while (hasNext() && Character.isDigit(getChar())) {
                        s.append(getChar());
                        nextChar();
                    }
                    tokens.add(new Real(Double.parseDouble(s.toString()), startPos));
                } else {
                    tokens.add(new Int(Integer.parseInt(s.toString()), startPos));
                }
                s.setLength(0);
            } else {
                switch (getChar()) {
                    case '+' -> tokens.add(new Add(readPos));
                    case '*', '×' -> tokens.add(new Mul(readPos));
                    default -> throw new InvalidInput("Invalid input", source, readPos, readPos + 1);
                }
                nextChar();
            }
        }
    }
    
    private char getChar() {
        return source.charAt(readPos);
    }
    
    private void nextChar() {
        readPos++;
    }

    private boolean hasNext() {
        return readPos < source.length();
    }
}
