package lesson02;

import java.util.Arrays;

public class homework02 {

    public static void main(String[] args) {

    /* 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    */

        int[] array1 = {1, 0, 0, 0, 1, 0, 0, 1, 1, 0};

        System.out.println("1 Задание. До: \t\t" + Arrays.toString(array1));
        insert(array1);
        System.out.println("1 Задание. После: \t" + Arrays.toString(array1));


    /* 2 Задать пустой целочисленный массив размером 8. Написать метод,
     который c помощью цикла заполнит его значениями1 4 7 10 13 16 19 22;
     */

        int[] arrayInt = new int[8];
        fillIn(arrayInt);
        System.out.println("2 Задание. Заполнение: \t" + Arrays.toString(arrayInt));

    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
    принимающий на вход массив и умножающий числа меньше 6 на 2;
     */

        int[] arrayDoubleInt = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3 Задание. До: \t\t" + Arrays.toString(arrayDoubleInt));
        arrayDouble(arrayDoubleInt);
        System.out.println("3 Задание. После: \t" + Arrays.toString(arrayDoubleInt));

    /*4 Задать одномерный массив. Написать методы поиска в нём минимального
     и максимального элемента;
     */

        int[] arrayMinMax = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = getMax(arrayMinMax);
        System.out.println("4 Задание. " + Arrays.toString(arrayMinMax) + " Максимальное: " + max);
        int min = getMin(arrayMinMax);
        System.out.println("4 Задание. " + Arrays.toString(arrayMinMax) + " Минимальное: " + min);

    /* 5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы);
     */

        int[][] squareArray = new int[5][5];
        fillSquareArray(squareArray);
        System.out.println("5 Задание. Заполненный массив:");
        printDoubleArray(squareArray);


    /*6** Написать метод, которому на вход подаётся одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен циклически
    сместить все элементы массива на n позиций.
    [1,2,3,4,5], -2 => [3,4,5,1,2]
    [1,2,3,4,5], 2 => [4,5,1,2,3]*/

        int[] moveArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n1 = -3;
        int n2 = 4;
        System.out.println("6 Задание. Исходный массив: " + Arrays.toString(moveArray));
        System.out.println("6 Задание. Массив со смещением на " + n1 + ": " + Arrays.toString(moveElementsArray(moveArray, n1)));
        System.out.println("6 Задание. Массив со смещением на " + n2 + ": " + Arrays.toString(moveElementsArray(moveArray, n2)));


    }


    public static void insert(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = (array[i] == 1) ? 0 : 1;
    }

    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3 + 1;
    }

    public static void arrayDouble(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) {
                array[i] *= 2;
            }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }

    public static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void fillSquareArray(int[][] squareArray) {
        for (int i = 0; i < squareArray.length; i++) {
            squareArray[i][i] = 1;
            squareArray[i][squareArray.length - 1 - i] = 1;
        }
    }

    public static void printDoubleArray(int[][] doubleArray) {
        for (int y = 0; y < doubleArray.length; y++) {
            for (int x = 0; x < doubleArray[y].length; x++) {
                System.out.print(doubleArray[y][x] + " | ");
            }
            System.out.println();
        }
    }

    public static int[] moveElementsArray(int[] moveArray, int n) {
        int len = moveArray.length;
        int[] tempArray = new int[len];
        n = n % len;
        for (int i = 0; i < len; i++) {
            tempArray[i] = moveArray[(i - n + len) % len];
        }
        return tempArray;
    }

    public static int[] moveElementsArray2(int[] moveArray, int n) {
        int len = moveArray.length;
        // int[] tempArray = new int[len];
        n = n % len;
        for (int i = 0; i < len; i++) {
            int temp = moveArray[i];
            moveArray[i] = moveArray[(i - n + len) % len];
            moveArray[(i - n + len) % len] = temp;
        }
        return moveArray;
    }



}