package lesson05.Model;

public class Animal {

    public static final int SWIM = 1;
    public static final int NOT_SWIM = 0;
    public static final int CANT_SWIM = -1;

    private String name;
    private int runLimit;
    private int swimLimit;
    private float jumpLimit;

    public Animal(String name, int runLimit, int swimLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    public boolean run(int value) {
        return runLimit >= value;
    }

    public int swim(int value) {
        return swimLimit >= value ? SWIM : NOT_SWIM;
    }

    public boolean jump(float value) {
        return jumpLimit >= value;
    }

    public String getName() {
        return this.name;
    }



}
