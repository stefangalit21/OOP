import java.util.List;

/**
 * Represents a Herbivore, a type of Animal that consumes plants for energy.
 * The Herbivore can perform actions such as eating plants and reproducing
 * based on its energy level.
 */
public class Herbivore extends Animal {

    /**
     * Constructs a new Herbivore with the given attributes.
     *
     * @param name  the name of the herbivore.
     * @param energy  the initial energy level of the herbivore.
     * @param x  the x-coordinate of the herbivore's position.
     * @param y  the y-coordinate of the herbivore's position.
     */
    public Herbivore(String name, int energy, int x, int y) {
        super(name, energy, x, y);
    }

    /**
     * Performs an action for the herbivore. The action involves searching
     * for and consuming plants in its environment.
     *
     * @param entities  a list of EcosystemEntity objects in the herbivore's vicinity.
     *                  The herbivore will search for plants in this list.
     * @return an ActionResult indicating the outcome of the action:
     *         - A {@code SuccessActionResult} if a plant was consumed, with the herbivore
     *           gaining 20 energy.
     *         - A {@code FailureActionResult} if no plants were found in the vicinity.
     */
    @Override
    public ActionResult action(List<EcosystemEntity> entities) {
        super.action(entities);
        for (EcosystemEntity entity : entities) {
            if (entity instanceof Plant) {
                entities.remove(entity);
                energy += 20;
                return new SuccessActionResult(name + " ate " + entity.name + " and gained energy.");
            }
        }
        return new FailureActionResult("No suitable prey found.");
    }

    /**
     * Checks if the herbivore has sufficient energy to reproduce.
     *
     * @return true if the herbivore's energy is greater than or equal to 40; false otherwise.
     */
    @Override
    public boolean canReproduce() {
        return energy >= 40;
    }

    /**
     * Creates a new Herbivore offspring if the reproduction criteria are met.
     * Reduces the parent's energy by 20 to account for the energy cost of reproduction.
     *
     * @return a new Herbivore instance representing the offspring. The offspring's name
     *         is the parent's name appended with "_child", it starts with 20 energy,
     *         and is located at the same position as the parent.
     */
    @Override
    public EcosystemEntity reproduce() {
        energy -= 20;
        return new Herbivore(name + "_child", 20, x, y);
    }
}
