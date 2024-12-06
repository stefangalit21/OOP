import java.util.ArrayList;
import java.util.List;

/**
 * The entry point for simulating an ecosystem.
 * This program initializes a list of ecosystem entities and simulates their interactions
 * over multiple steps, logging the results to the console.
 */
public class Main {

    /**
     * The main method where the simulation is executed.
     *
     * @param args  command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the ecosystem with a predefined list of entities.
        List<EcosystemEntity> entities = getEcosystemEntities();
        Ecosystem ecosystem = new Ecosystem(entities);

        // Simulate the ecosystem for 5 steps, logging each step's result.
        for (int step = 1; step <= 5; step++) {
            System.out.println("==== Step " + step + " ====");
            ecosystem.simulateStep();
            System.out.println(ecosystem);
        }
    }

    /**
     * Creates and initializes a list of ecosystem entities for the simulation.
     * The entities include plants, herbivores, carnivores, and omnivores.
     *
     * @return a list of {@link EcosystemEntity} objects representing the ecosystem's initial state.
     */
    private static List<EcosystemEntity> getEcosystemEntities() {
        List<EcosystemEntity> entities = new ArrayList<>();

        // Add 10 plants to the ecosystem with sequential names and positions.
        for (int i = 0; i < 10; i++) {
            entities.add(new Plant("Plant" + (i + 1), 10, i, 0));
        }

        // Add herbivores to the ecosystem.
        entities.add(new Herbivore("Rabbit1", 30, 1, 1));
        entities.add(new Herbivore("Rabbit2", 30, 2, 1));
        entities.add(new Herbivore("Rabbit3", 30, 3, 1));

        // Add carnivores to the ecosystem.
        entities.add(new Carnivore("Wolf1", 50, 4, 2));
        entities.add(new Carnivore("Wolf2", 50, 4, 3));

        // Add omnivores to the ecosystem.
        entities.add(new Omnivore("Bear1", 70, 3, 3));
        entities.add(new Omnivore("Bear2", 70, 3, 4));

        return entities;
    }
}
