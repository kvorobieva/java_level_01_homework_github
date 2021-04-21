package lesson05;

import lesson05.Model.Animal;

public class Bird extends Animal {

    public Bird(String name) {
        super(name, 5, 0, 0.2f);
    }

    @Override
    public int swim(int value) {
        return Animal.CANT_SWIM;
    }
}
