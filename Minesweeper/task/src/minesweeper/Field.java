package minesweeper;

public class Field {
    private FieldStates realState;
    private FieldStates displayState;

    public Field() {
        realState =  FieldStates.EMPTY;
        displayState = FieldStates.HIDDEN;
    }

    public void setAsBomb() {
        realState = FieldStates.BOMB;
    }

    public boolean isBomb(){
        return realState == FieldStates.BOMB;
    }

    public boolean hasBombsAround() {
        return realState == FieldStates.NUMBER;
    }

    public void addBombAround() {
        if(realState != FieldStates.NUMBER) {
            realState = FieldStates.NUMBER;
        }

        realState.addNumber();
    }

    public void toggleMark() {
        if(displayState == FieldStates.MARKED) {
            displayState = FieldStates.HIDDEN;
        } else if(displayState == FieldStates.HIDDEN) {
            displayState = FieldStates.MARKED;
        }
    }

    public void reveal() {
        if(displayState == FieldStates.HIDDEN) {
            displayState = realState;
        }
    }

    public char getValue() {
        return displayState.getValue();
    }

}
