package lesson05;

import lesson05.Model.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 10, 0.5f);
    }

    public Dog(String name, int runLimit) {
        super(name, runLimit, 10, 0.5f);
    }


}

