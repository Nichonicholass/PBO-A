import java.util.List;

public class Rabbit extends Animal {
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 40;
    private static final double BREEDING_PROBABILITY = 0.12;
    private static final int MAX_LITTER_SIZE = 4;

    public Rabbit(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        incrementAge();
        if (isAlive()) {
            giveBirth(newAnimals);
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
                getField().place(this, newLocation);
            } else {
                setDead(); // Overcrowding
            }
        }
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected boolean canReproduce() {
        return getAge() >= BREEDING_AGE;
    }

    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected Animal createYoung(Field field, Location location) {
        return new Rabbit(false, field, location);
    }

    @Override
    protected int getRandomAge() {
        return Randomizer.getRandom().nextInt(MAX_AGE);
    }
}
