package lesson04;

public class Staff {

    private static final int currentYear = 2021;

    private String surname;
    private String name;
    private String secondName;
    private String position;
    private String phone;
    private float salary;
    boolean salaryIncreased;
    private int birthYear;
    private int uid;

    private static int id = 0;

    public Staff(String surname,
                 String name,
                 String secondName,
                 String position,
                 String phone,
                 float salary,
                 int birthYear) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
        this.uid = ++id;
        this.salaryIncreased = false;
    }

    public String getName() {
        return this.name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPosition() {
        return this.position;
    }

    public String getPhone() { return this.phone; }

    public int getSalary() { return (int) this.salary; }

    public int getAge() { return currentYear - this.birthYear; }

    public int getID() {
        return this.uid;
    }

    public String getFullName() {
        return this.name + " " + this.secondName + " " + this.surname;
    }

    public String getFullInfo() {
        return this.uid + ". ФИО: " + this.surname + " " + this.name + " " + this.secondName
                + ". Должность: " + this.position
                + ". Телефон: " + this.phone
                + ". З/п: " + getSalary() + " рублей. Возраст: " + getAge();
    }

    void getNamePosition() {
        System.out.println(surname + " " + name + " " + secondName + " - " + position);
    }

    public void setSalary(int increase) {
        this.salary += increase;
        this.salaryIncreased = true;
    }

}