package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many mines do you want on the field? ");
        int mines = new Scanner(System.in).nextInt();

        Minefield minefield = new Minefield(mines);
        minefield.printMinefield();
    }
}
