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

    public void addNumber() {
        if(this == NUMBER) {
            int x = Integer.parseInt(Character.toString(value)) + 1;
            value = Integer.toString(x).charAt(0);
        }
    }

}
