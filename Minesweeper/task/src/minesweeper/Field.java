package minesweeper;

public class Field {

    private final char BOMB_SIGN = 'X';
    private final char EMPTY_SIGN = '.';
    private final char MARKED_SIGN = '*';

    private boolean hidden = false;
    private boolean marked = false;

    private int bombsAround = 0;

    public Field() {

    }

    public void set(char val) {
        value = val;
    }

    public boolean isBomb(){
        return value == BOMB_SIGN;
    }

    public boolean hasBombsAround() {
        return bombsAround > 0;
    }

    public void bombAround() {
        bombsAround++;
    }

    public void toggleMark() {
        marked =! marked;
    }

    public char getValue() {
        if(isBomb()) {

        }
        if(hidden) {
            if(marked) {
                return MARKED_SIGN;
            } else {
                return EMPTY_SIGN;
            }
        } else {
            if(hasBombsAround()) {
                return Integer.toString(bombsAround).charAt(0);
            } else {
                return EMPTY_SIGN;
            }
        }
    }

}
