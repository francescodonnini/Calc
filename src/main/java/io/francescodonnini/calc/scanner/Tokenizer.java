package io.francescodonnini.calc.scanner;

import io.francescodonnini.calc.error.InvalidInput;
import io.francescodonnini.calc.token.Token;

import java.util.Iterator;

public interface Tokenizer {
    Iterator<Token> tokenize() throws InvalidInput;
}
