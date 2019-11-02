package minesweeper;

public enum FieldStates {
    HIDDEN('.'),
    EMPTY('.'),
    MARKED('*'),
    BOMB('X'),
    NUMBER('0');

    private char value;

    private FieldStates(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

}
