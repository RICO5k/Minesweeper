package minesweeper;

import java.util.Scanner;

public class Game {

    private Scanner scanner;

    private Minefield minefield;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        initMinefield();

        while (minefield.allBombsAreMarked()) {
            minefield.printMinefield();

            System.out.print("Set/delete mines marks (x and y coordinates): ");

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            setMarkIfPossible(x, y);
        }
    }

    public void initMinefield() {
        System.out.println("How many mines do you want on the field? ");
        int mines = scanner.nextInt();

        minefield = new Minefield(mines);
    }

    public void setMarkIfPossible(int x, int y) {
        if(minefield.isMarkable(x, y)) {
            minefield.mark(x, y);
        }
    }

}
