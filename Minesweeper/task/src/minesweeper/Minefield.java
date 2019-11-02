package minesweeper;

import java.util.Random;

public class Minefield {

    private final int MINEFIELD_SIZE = 9;
    private Field[][] fields;

    public Minefield(int amountOfMines) {
        fields = new Field[MINEFIELD_SIZE][MINEFIELD_SIZE];

        initFields();

        generateRandomMines(amountOfMines);
    }

    public void initFields() {
        for (int i = 0; i < MINEFIELD_SIZE; i++) {
            for (int j = 0; j < MINEFIELD_SIZE; j++) {
                fields[i][j] = new Field();
            }
        }
    }

    private void generateRandomMines(int howMany) {
        Random rand = new Random();

        for(int i=0; i<howMany; i++) {
            int mineX;
            int mineY;

            do {
                mineX = rand.nextInt(MINEFIELD_SIZE);
                mineY = rand.nextInt(MINEFIELD_SIZE);
            } while(fields[mineX][mineY].isBomb());

            fields[mineX][mineY].setAsBomb();
            fields[mineX][mineY].reveal();

            fillCellsAround(mineX, mineY);
        }
    }

    private void fillCellsAround(int x, int y) {
        int xStart = x-1 < 0 ? x : x-1;
        int xEnd = x+1 >= MINEFIELD_SIZE ? x : x+1;

        int yStart = y-1 < 0 ? y : y-1;
        int yEnd = y+1 >= MINEFIELD_SIZE ? y : y+1;

        for(int i=xStart; i<=xEnd; i++) {
            for(int j=yStart; j<=yEnd; j++) {
                if(fields[i][j].isBomb()) {
                    continue;
                } else {
                    fields[i][j].addBombAround();
                }
            }
        }
    }

    public void printMinefield() {
        for(int i=0; i< MINEFIELD_SIZE; i++) {
            for(int j=0; j< MINEFIELD_SIZE; j++) {
                System.out.print(fields[i][j].getValue());
            }
            System.out.print('\n');
        }
    }

}
