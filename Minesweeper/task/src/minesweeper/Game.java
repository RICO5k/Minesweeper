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

        while (!minefield.allBombsAreMarked()) {
            minefield.printMinefield();

            System.out.print("Set/delete mines marks (x and y coordinates): ");

            int y = scanner.nextInt()-1;
            int x = scanner.nextInt()-1;

            setMarkIfPossible(x, y);
        }

        minefield.printMinefield();
        System.out.println("Congratulations! You found all mines!");
    }

    public void initMinefield() {
        System.out.println("How many mines do you want on the field? ");
        int mines = scanner.nextInt();

        minefield = new Minefield(mines);
    }

    public void setMarkIfPossible(int x, int y) {
        if(minefield.isMarkable(x, y)) {
            minefield.mark(x, y);
        } else {
            System.out.println("There is a number here!");
        }
    }

}
