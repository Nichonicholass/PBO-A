import java.util.List;

public class Fox extends Animal {
    private static final int BREEDING_AGE = 10;
    private static final int MAX_AGE = 60;
    private static final double BREEDING_PROBABILITY = 0.08;
    private static final int MAX_LITTER_SIZE = 2;
    private static final int RABBIT_FOOD_VALUE = 9;

    private int foodLevel;

    public Fox(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
        this.foodLevel = randomAge ? Randomizer.getRandom().nextInt(RABBIT_FOOD_VALUE) : RABBIT_FOOD_VALUE;
    }

    @Override
    public void act(List<Animal> newAnimals) {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            giveBirth(newAnimals);
            Location newLocation = findFood();
            if (newLocation == null) {
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            if (newLocation != null) {
                setLocation(newLocation);
                getField().place(this, newLocation);
            } else {
                setDead(); // Overcrowding
            }
        }
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        for (Location where : adjacent) {
            Animal animal = getField().getObjectAt(where);
            if (animal instanceof Rabbit && animal.isAlive()) {
                animal.setDead();
                foodLevel = RABBIT_FOOD_VALUE;
                return where;
            }
        }
        return null;
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
        return new Fox(false, field, location);
    }

    @Override
    protected int getRandomAge() {
        return Randomizer.getRandom().nextInt(MAX_AGE);
    }
}
