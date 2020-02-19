package com.codersbay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int columns = 5;
        int rows = 5;
        int[][] bingo = new int[columns][rows];
        int[][] bounds = {{1, 16}, {16, 31}, {31, 46}, {46, 61}, {61, 76}};
        List<Integer> list = new ArrayList<Integer>();

        int number = 0;
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
                for (int element : bingo[i]) {        //convert Array to Arraylist
                    list.add(element);
                }
                number = random.nextInt(high - low) + low;  //

                while (list.contains(number)) {      // filter double numbers
                    number = random.nextInt(high - low) + low;
                }
                bingo[i][j] = number;
            }
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