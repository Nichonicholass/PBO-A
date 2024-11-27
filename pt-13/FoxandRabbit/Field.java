import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {
    private Animal[][] field;
    private int depth;
    private int width;

    public Field(int depth, int width) {
        this.depth = depth;
        this.width = width;
        field = new Animal[depth][width];
    }

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Animal animal, Location location) {
        field[location.getRow()][location.getCol()] = animal;
    }

    public Animal getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public List<Location> getFreeAdjacentLocations(Location location) {
        List<Location> free = new ArrayList<>();
        for (Location loc : adjacentLocations(location)) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        return free;
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = getFreeAdjacentLocations(location);
        if (!free.isEmpty()) {
            return free.get(0);
        }
        return null;
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int row = location.getRow();
        int col = location.getCol();
        for (int roffset = -1; roffset <= 1; roffset++) {
            for (int coffset = -1; coffset <= 1; coffset++) {
                if (roffset != 0 || coffset != 0) {
                    int newRow = row + roffset;
                    int newCol = col + coffset;
                    if (isValidLocation(newRow, newCol)) {
                        locations.add(new Location(newRow, newCol));
                    }
                }
            }
        }
        Collections.shuffle(locations, Randomizer.getRandom());
        return locations;
    }

    public void display() {
        for (int row = 0; row < depth; row++) {
            for (int col = 0; col < width; col++) {
                Animal animal = field[row][col];
                if (animal instanceof Rabbit) {
                    System.out.print("R "); 
                } else if (animal instanceof Fox) {
                    System.out.print("F "); 
                } else {
                    System.out.print(". "); 
                }
            }
            System.out.println(); 
        }
        System.out.println(); 
    }
    

    private boolean isValidLocation(int row, int col) {
        return row >= 0 && row < depth && col >= 0 && col < width;
    }
}
