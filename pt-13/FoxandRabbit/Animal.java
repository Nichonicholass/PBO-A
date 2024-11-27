import java.util.List;

public abstract class Animal {
    private int age;
    private boolean alive;
    private Location location;
    private Field field;

    public Animal(boolean randomAge, Field field, Location location) {
        this.alive = true;
        this.field = field;
        this.location = location;
        this.age = randomAge ? getRandomAge() : 0;
    }

    public abstract void act(List<Animal> newAnimals);

    public void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Field getField() {
        return field;
    }

    public int getAge() {
        return age;
    }

    public void giveBirth(List<Animal> newAnimals) {
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = reproduce();
        for (int b = 0; b < births && !free.isEmpty(); b++) {
            Location loc = free.remove(0);
            Animal young = createYoung(field, loc);
            newAnimals.add(young);
            field.place(young, loc);
        }
    }

    private int reproduce() {
        if (canReproduce() && Randomizer.getRandom().nextDouble() <= getBreedingProbability()) {
            return Randomizer.getRandom().nextInt(getMaxLitterSize()) + 1;
        }
        return 0;
    }

    protected abstract int getMaxAge();
    protected abstract boolean canReproduce();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
    protected abstract Animal createYoung(Field field, Location location);
    protected abstract int getRandomAge();
}
