package minesweeper;

public class Field {
    private FieldStates realState;
    private FieldStates displayState;

    private int bombsAround = 0;

    public Field() {
        realState =  FieldStates.EMPTY;
        displayState = FieldStates.HIDDEN;
    }

    public void setAsBomb() {
        realState = FieldStates.BOMB;

        displayState = FieldStates.HIDDEN;
    }

    public boolean isBomb(){
        return realState == FieldStates.BOMB;
    }

    public boolean isMarked() {
        return displayState == FieldStates.MARKED;
    }

    public boolean hasBombsAround() {
        return realState == FieldStates.NUMBER;
    }

    public void addBombAround() {
        System.out.println(realState.toString());

        if(realState != FieldStates.NUMBER) {
            realState = FieldStates.NUMBER;
            reveal();
        }

        bombsAround++;
        updateDisplay();
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

    private void updateDisplay() {
        if(displayState != FieldStates.HIDDEN && displayState != FieldStates.MARKED) {
            displayState = realState;
        }
    }

    public char getValue() {
        if(displayState != FieldStates.NUMBER) {
            return displayState.getValue();
        } else {
            return Integer.toString(bombsAround).charAt(0);
        }
    }

}
