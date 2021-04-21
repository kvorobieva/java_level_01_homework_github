package lesson05;

import lesson05.Model.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 0, 2f);
    }

    @Override
    public int swim(int value) {
        return Animal.CANT_SWIM;
    }
}
