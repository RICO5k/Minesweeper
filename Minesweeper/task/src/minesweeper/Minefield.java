package minesweeper;

import java.util.Random;

public class Minefield {

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
                minefield[i][j] = '.';
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
            } while(minefield[mineX][mineY] == 'X');

            minefield[mineX][mineY] = 'X';
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
                if(minefield[i][j] == 'X') {
                    continue;
                } else if(minefield[i][j] == '.') {
                    minefield[i][j] = '1';
                } else {
                    minefield[i][j] = Integer.toString(Integer.parseInt( Character.toString(minefield[i][j]) ) + 1).charAt(0);
                }
            }
        }
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
