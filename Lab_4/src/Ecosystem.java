import java.util.ArrayList;
import java.util.List;

/**
 * Represents the ecosystem, a collection of entities that interact with one another.
 * The ecosystem supports adding entities, simulating interactions, and handling reproduction.
 */
public class Ecosystem {

    /** A list of all entities present in the ecosystem. */
    private List<EcosystemEntity> entities = new ArrayList<>();

    /**
     * Constructs an Ecosystem with an initial set of entities.
     *
     * @param entities  a list of {@link EcosystemEntity} objects to initialize the ecosystem.
     */
    public Ecosystem(List<EcosystemEntity> entities) {
        this.entities = entities;
    }

    /**
     * Adds a new entity to the ecosystem.
     *
     * @param entity  the {@link EcosystemEntity} to be added.
     */
    public void addEntity(EcosystemEntity entity) {
        entities.add(entity);
    }

    /**
     * Simulates a single step in the ecosystem, allowing each entity to perform its action.
     * Actions may include interacting with other entities (e.g., eating, moving).
     * The method also handles reproduction at the end of the step.
     */
    public void simulateStep() {
        // Create a snapshot of the current entities to safely iterate while modifying the original list.
        List<EcosystemEntity> entitiesSnapshot = new ArrayList<>(entities);
        for (EcosystemEntity entity : entitiesSnapshot) {
            ActionResult result = entity.action(entities);

            // Print success action results to the console.
            if (result instanceof SuccessActionResult) {
                System.out.println(result.getResult());
            }

            // Uncomment the following block to handle and log failure action results:
            // if (result instanceof FailureActionResult) {
            //     System.out.println("\t\tFailure!!!");
            // }
        }
        handleReproduction();
    }

    /**
     * Handles reproduction for all entities that meet the reproduction criteria.
     * New offspring are added to the ecosystem, and a message is logged for each reproduction event.
     */
    private void handleReproduction() {
        List<EcosystemEntity> newEntities = new ArrayList<>();
        for (EcosystemEntity entity : entities) {
            if (entity.canReproduce()) {
                EcosystemEntity offspring = entity.reproduce();
                newEntities.add(offspring);
                System.out.println(entity.name + " reproduced: " + offspring.name);
            }
        }
        entities.addAll(newEntities);
    }

    /**
     * Provides a string representation of the ecosystem's current state,
     * including the name and energy level of each entity.
     *
     * @return a string summarizing the current state of the ecosystem.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current State:\n");
        for (EcosystemEntity entity : entities) {
            sb.append(entity.name).append(" - Energy: ").append(entity.energy).append("\n");
        }
        sb.append("----------------------------");
        return sb.toString();
    }
}
