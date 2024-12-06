import java.util.List;

/**
 * Represents a carnivorous animal in the ecosystem.
 * The Carnivore hunts herbivores for energy and can reproduce when it has sufficient energy.
 */
public class Carnivore extends Animal {

    /**
     * Constructs a new Carnivore with the specified attributes.
     *
     * @param name  the name of the carnivore.
     * @param energy  the initial energy level of the carnivore.
     * @param x  the x-coordinate of the carnivore's position.
     * @param y  the y-coordinate of the carnivore's position.
     */
    public Carnivore(String name, int energy, int x, int y) {
        super(name, energy, x, y);
    }

    /**
     * Performs an action for the carnivore. The action involves searching for
     * herbivores in its vicinity to hunt and gain energy.
     *
     * @param entities  a list of {@link EcosystemEntity} objects in the carnivore's vicinity.
     *                  The carnivore will search this list for herbivores to hunt.
     * @return an {@link ActionResult} indicating the outcome of the action:
     *         - A {@code SuccessActionResult} if a herbivore was hunted, with the carnivore
     *           gaining 30 energy.
     *         - A {@code FailureActionResult} if no herbivores were found in the vicinity.
     */
    @Override
    public ActionResult action(List<EcosystemEntity> entities) {
        super.action(entities);
        for (EcosystemEntity entity : entities) {
            if (entity instanceof Herbivore) {
                entities.remove(entity);
                energy += 30;
                return new SuccessActionResult(name + " hunted " + entity.name + " and gained energy.");
            }
        }
        return new FailureActionResult("No suitable prey found.");
    }

    /**
     * Checks if the carnivore has sufficient energy to reproduce.
     *
     * @return true if the carnivore's energy is greater than or equal to 50; false otherwise.
     */
    @Override
    public boolean canReproduce() {
        return energy >= 50;
    }

    /**
     * Creates a new Carnivore offspring if the reproduction criteria are met.
     * Reduces the parent's energy by 25 to account for the energy cost of reproduction.
     *
     * @return a new {@link Carnivore} instance representing the offspring. The offspring's name
     *         is the parent's name appended with "_child", it starts with 25 energy,
     *         and is located at the same position as the parent.
     */
    @Override
    public EcosystemEntity reproduce() {
        energy -= 25;
        return new Carnivore(name + "_child", 25, x, y);
    }
}
