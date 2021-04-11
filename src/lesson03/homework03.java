package lesson03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework03 {

    public static char[][] field;
    public static int fieldSizeX;
    public static int fieldSizeY;

    public static char human = 'X';
    public static char ai = 'O';
    public static char empty = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random(); //[0;1)


    public static void createField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
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

            if (field[i][i] == player) {
                arr[2 * size] += 1;
            }
            if (field[i][size - i - 1] == player) {
                arr[2 * size + 1] += 1;
            }

            for (int j = 0; j < size; j++) {
                if (field[i][j] == player) {
                    arr[i] += 1;
                }
                if (field[j][i] == player) {
                    arr[size + i] += 1;
                }
            }
        }
        // Проверка System.out.println(player + ' ' + Arrays.toString(arr));
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == size) {
                return true;
            }
        }
        return false;
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

//        System.out.println("Я распечатал то, что ты ввел в консоль = " + scanner.nextLine());

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
