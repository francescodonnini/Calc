package io.francescodonnini.calc.error;

public class InvalidInput extends Exception {
    private final String errorString;
    private final int startPos;
    private final int endPos;

    public InvalidInput(String errorMsg, String errorString, int startPos, int endPos) {
        super(errorMsg);
        this.errorString = errorString;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public String getErrorString() {
        return errorString;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }
}
