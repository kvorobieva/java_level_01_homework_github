package lesson01;

public class homework01 {

    public static void main(String[] args) {

        //Первое задание
        int valueA = 20;
        int valueB = 16;
        int valueC = 36;
        int valueD = 5;

        float result1;
        result1 = myMath1(valueA, valueB, valueC, valueD);
        System.out.println("Результат задания № 1: " + result1);

        //Второе задание
        int valueE = 15;
        int valueF = 7;
        System.out.println("Результат задания № 2: Сумма " + valueE + " и " + valueF
                + " лежит в пределах от 10 до 20 (включительно)? " + (myMath2(valueE, valueF) ? "Да" : "Нет"));

        //Третье задание
        int positive = -5;
        if (myMath3(positive)) {
            System.out.println("Результат задания № 3: Число " + positive + " положительное");
        }
        else {
            System.out.println("Результат задания № 3: Число " + positive + " отрицательное");
        }

        //Четвертое задание
        System.out.println("Результат задания № 4: " + hello("Александр"));

        //Пятое задание
        int testYear = 2022;
        if (leapYear(testYear)) {
            System.out.println("Результат задания № 5: Является ли год " + testYear + " вискосным? Да");
        }
        else {
            System.out.println("Результат задания № 5: Является ли год " + testYear + " вискосным? Нет");
        }
    }

    public static float myMath1(int valueA, int valueB, int valueC, int valueD) {
        return valueA * (valueB + (float) valueC / valueD);
    }

    public static boolean myMath2(int valueA, int valueB) {
        int result2 = valueA + valueB;
        return (result2 >= 10 && result2 <=20);
    }

    public static boolean myMath3(int valueA) {
        return valueA >= 0;
    }

    public static String hello (String name) {
        return "Привет, " + name + "!";
    }

    public static boolean leapYear (int year){
        return (year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0);
    }
}
