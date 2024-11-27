import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Field field;
    private List<Animal> animals;

    public Simulator(int depth, int width) {
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate();
    }

    public void simulate(int steps) {
        for (int step = 1; step <= steps; step++) {
            simulateOneStep();
        }
    }

    private void simulateOneStep() {
        List<Animal> newAnimals = new ArrayList<>();
        for (Animal animal : new ArrayList<>(animals)) {
            if (animal.isAlive()) {
                animal.act(newAnimals);
            } else {
                animals.remove(animal);
            }
        }
        animals.addAll(newAnimals);
        field.display(); // Tampilkan status lapangan setelah setiap langkah
    }
    
    

    private void populate() {
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (Randomizer.getRandom().nextDouble() <= 0.08) {
                    Rabbit rabbit = new Rabbit(true, field, new Location(row, col));
                    animals.add(rabbit);
                    field.place(rabbit, new Location(row, col));
                } else if (Randomizer.getRandom().nextDouble() <= 0.02) {
                    Fox fox = new Fox(true, field, new Location(row, col));
                    animals.add(fox);
                    field.place(fox, new Location(row, col));
                }
            }
        }
    }
}
