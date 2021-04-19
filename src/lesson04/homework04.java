package lesson04;

public class homework04 {

    public static void main(String[] args) {

        //1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;

        Staff staffUnit = new Staff("Иванов", "Иван", "Иванович", "Директор", "+79991234567", 100000, 1975);

        System.out.println(staffUnit.getFullInfo());

        System.out.println("--------------------------------");

        //4 Вывести при помощи методов из пункта 3 ФИО и должность.

        staffUnit.getNamePosition();

        System.out.println("--------------------------------");

        //5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        Staff[] staffs = {
                staffUnit,
                new Staff("Петров", "Петр", "Петрович", "Scrum manager", "+79861234567", 80000, 1980),
                new Staff("Андреев", "Андрей", "Андреевич", "Frontend", "+79871234567", 60000, 1985),
                new Staff("Николаев", "Николай", "Николаевич", "Backend", "+79841234567", 60000, 1987),
                new Staff("Евгеньева", "Евгения", "Евгеньевна", "QA Engineer", "+79831234567", 50000, 1989)
        };

        System.out.println("Сотрудники: ");

        for (int i = 0; i < staffs.length; i++) {
            System.out.println(staffs[i].getFullInfo());
        }

        System.out.println("--------------------------------");

        System.out.println("Сотрудники старше 40 лет: ");

        for (int i = 0; i < staffs.length; i++) {
            if (staffs[i].getAge() >= 40) {
                System.out.println(staffs[i].getFullInfo());
            }
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < staffs.length; i++) {
            increaseSalaryByAge(staffs[i], 35, 10000);
        }
        System.out.println("Сотрудники старше 35 лет c увеличенной з/п на 10000 рублей: ");

        printIncreasedSalaries(staffs);

    }

    public static void increaseSalaryByAge(Staff staffUnit, int pivotAge, int increase) {
        if (staffUnit.getAge() >= pivotAge) {
            staffUnit.setSalary(increase);
        }
    }

    private static void printIncreasedSalaries(Staff[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].salaryIncreased) {
                System.out.println(arr[i].getFullInfo());
            }
        }
    }

}
