package lesson03;

import java.util.Random;
import java.util.Scanner;

public class homework03 {

    public static char[][] field;
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int winCount = 4;

    public static char human = 'X';
    public static char ai = 'O';
    public static char empty = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random(); //[0;1)


    public static void createField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = empty;
            }
        }
    }

    public static void viewField() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void turnHuman() {
        int cellX;
        int cellY;

        do {
            System.out.println("Enter coordinates cell: ");
            cellX = scanner.nextInt() - 1;
            cellY = scanner.nextInt() - 1;
        } while (!validCell(cellY, cellX) || !emptyCell(cellY, cellX));
        field[cellX][cellY] = human;
    }

    public static void turnAI() {
        int cellX;
        int cellY;

        do {
            cellX = random.nextInt(fieldSizeX); //[0;3)
            cellY = random.nextInt(fieldSizeY);
        } while (!emptyCell(cellY, cellX));
        field[cellX][cellY] = ai;
    }

    public static boolean winGame(char player) {
        int size = fieldSizeX;
        int[] arr = new int[2 * size + 2];

        for (int i = 0; i < size; i++) {
            checkAndCount(field[i][i], player, arr, size * 2);
            checkAndCount(field[i][size - i - 1], player, arr, size * 2 + 1);

            if (arr[size * 2] == winCount || arr[size * 2 + 1] == winCount) {
                return true;
            }

            for (int j = 0; j < size; j++) {
                checkAndCount(field[i][j], player, arr, i);
                checkAndCount(field[j][i], player, arr, size + i);

                if (arr[i] == winCount || arr[size + i] == winCount) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void checkAndCount(char cell, char player, int[] arr, int index) {
        if (cell == player) {
            arr[index] += 1;
        } else if (arr[index] < winCount) {
            arr[index] = 0;
        }
    }

    public static boolean draw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == empty) return false;
            }
        }
        return true;
    }


    public static boolean validCell(int cellY, int cellX) {
        return cellX >= 0 && cellX < fieldSizeX && cellY >= 0 && cellY < fieldSizeY;
    }

    public static boolean emptyCell(int cellY, int cellX) {
        return field[cellX][cellY] == empty;
    }

    public static void main(String[] args) {

        createField();
        viewField();

        while (true) {
            turnHuman();
            viewField();

            if (winGame(human)) {
                System.out.println("Human wins!");
                break;
            }

            if (draw()) {
                System.out.println("DRAW!!!");
                break;
            }

            turnAI();
            viewField();

            if (winGame(ai)) {
                System.out.println("AI wins!");
                break;
            }

            if (draw()) {
                System.out.println("DRAW!!!");
                break;
            }

        }
    }
}
