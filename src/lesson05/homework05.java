package lesson05;

import lesson05.Model.Animal;

public class homework05 {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Dog Pluto");
        Dog dog2 = new Dog("Dog Belka", 400);
        Dog dog3 = new Dog("Dog Strelka", 600);
        Horse horse = new Horse ("Horse Maximus");
        Bird bird = new Bird("Bird Rio");
        Cat cat = new Cat("Cat Tom");

        Animal[] zoo = {dog1, dog2, horse, bird, cat};
        for (int i = 0; i < zoo.length; i++) {
            System.out.println(tryToRun(zoo[i], 500));
            System.out.println(tryToSwim(zoo[i], 50));
            System.out.println(tryToJump(zoo[i], 1.9f));
        }
    }

    private static String tryToRun(Animal animal, int distance) {
        return animal.run(distance) ? animal.getName() + " has run " + distance + " meters!" : animal.getName() + " hasn't run " + distance + " meters because it's far for him!";
    }

    private static String tryToJump(Animal animal, float distance) {
        return animal.jump(distance) ? animal.getName() + " has jumped " + distance + " meters!" : animal.getName() + " hasn't jumped " + distance + " meters because it's far for him!";
    }

    private static String tryToSwim(Animal animal, int distance) {
        switch (animal.swim(distance)) {
            case Animal.CANT_SWIM:
                return animal.getName() + " can't swim at all!";

            case Animal.SWIM:
                return animal.getName() + " has swum " + distance + " meters!";

            case Animal.NOT_SWIM:
                return animal.getName() + " hasn't swum " + distance + " meters because it's far for him!";
            default: return "";
        }

    }

}
