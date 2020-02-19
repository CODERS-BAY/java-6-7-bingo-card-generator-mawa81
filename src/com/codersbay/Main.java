package com.codersbay;

import java.util.Random;

/*Die Regeln für eine Bingo-Karte sind einfach: Eine Bingo Karte besteht aus 24 eindeutigen zufälligen Nummern:

        5 Zahlen für die B Spalte im Bereich 1 bis 15
        5 Zahlen für die I Spalte im Bereich 16 bis 30
        4 Zahlen für die N Spalte im Bereich 31 bis 45
        5 Zahlen für die G Spalte im Bereich 46 bis 60
        5 Zahlen für die O Spalte im Bereich 61 bis 75
*/
public class Main {
    public static void main(String[] args) {
        int columns = 5;
        int rows = 5;
        int[][] bingo = new int[columns][rows];
        int[][] bounds = {{1, 16}, {16, 31}, {31, 46}, {46, 61}, {61, 76}};

        Random random = new Random();

        // Create random numbers for each column
        for (int i = 0; i < columns; i++) {
            int low = bounds[i][0];
            int high = bounds[i][1];
            for (int j = 0; j < rows; j++) {
                if (i == 2 && j == 2) {           //empty field in the middle(0)
                    bingo[i][j] = 0;
                    continue;
                }
                int number = random.nextInt(high - low) + low;
                bingo[i][j] = number;
                System.out.println(number);
            }
            System.out.println();
        }

        // Print to console
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 2 && j == 2) {           //empty field in the middle("    ")
                    System.out.print("    ");
                    continue;
                }
                System.out.printf(" %2d ", bingo[j][i]);
            }
            System.out.println();
        }


    }
}