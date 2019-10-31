package minesweeper;

import java.util.Random;

public class Minefield {

    private final char BOMB_SIGN = 'X';
    private final char EMPTY_SIGN = '.';

    private final int MINEFIELD_SIZE = 9;
    private char[][] minefield;

    public Minefield(int amountOfMines) {
        minefield = new char[MINEFIELD_SIZE][MINEFIELD_SIZE];

        fillEmpty();
        generateRandomMines(amountOfMines);
    }

    private void fillEmpty() {
        for (int i=0; i<MINEFIELD_SIZE; i++) {
            for (int j=0; j<MINEFIELD_SIZE; j++) {
                minefield[i][j] = EMPTY_SIGN;
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
            } while(minefield[mineX][mineY] == BOMB_SIGN);

            minefield[mineX][mineY] = BOMB_SIGN;
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
                if(minefield[i][j] == BOMB_SIGN) {
                    continue;
                } else if(minefield[i][j] == EMPTY_SIGN) {
                    minefield[i][j] = '1';
                } else {
                    addOneToField(i, j);
                }
            }
        }
    }

    private void addOneToField(int x, int y) {
        int number = Integer.parseInt( Character.toString(minefield[x][y] ));

        number++;

        minefield[x][y] = Integer.toString(number).charAt(0);
    }

    public void printMinefield() {
        for(int i=0; i< MINEFIELD_SIZE; i++) {
            for(int j=0; j< MINEFIELD_SIZE; j++) {
                System.out.print(minefield[i][j]);
            }
            System.out.print('\n');
        }
    }

}
