import java.util.List;

/**
 * Represents a Plant in the ecosystem, extending the EcosystemEntity class.
 */
public class Plant extends EcosystemEntity {
    
    /**
     * Constructs a new Plant with the specified attributes.
     *
     * @param name   The name of the plant.
     * @param energy The initial energy level of the plant.
     * @param x      The x-coordinate of the plant's position.
     * @param y      The y-coordinate of the plant's position.
     */
    public Plant(String name, int energy, int x, int y) {
        super(name, energy, x, y);
    }

    /**
     * Performs the plant's action in the ecosystem, which is to grow and increase its energy.
     *
     * @param entities A list of all entities in the ecosystem (unused in this implementation).
     * @return An ActionResult indicating the success of the growth action and the plant's updated energy.
     */
    @Override
    public ActionResult action(List<EcosystemEntity> entities) {
        energy += 5;
        return new SuccessActionResult(name + " grows, energy: " + energy);
    }

    /**
     * Checks if the plant has enough energy to reproduce.
     *
     * @return true if the plant's energy is 20 or greater, false otherwise.
     */
    @Override
    public boolean canReproduce() {
        return energy >= 20;
    }

    /**
     * Creates a new Plant instance as offspring of this plant.
     * This method reduces the parent plant's energy by 10 and creates a new plant with 10 energy.
     *
     * @return A new Plant instance representing the offspring.
     */
    @Override
    public EcosystemEntity reproduce() {
        energy -= 10;
        return new Plant(name + "_child", 10, x, y);
    }
}
