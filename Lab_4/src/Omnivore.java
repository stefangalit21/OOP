import java.util.List;

public class Omnivore extends Animal {
    /**
     * Constructs a new Omnivore object.
     *
     * @param name   The name of the omnivore.
     * @param energy The initial energy level of the omnivore.
     * @param x      The x-coordinate of the omnivore's position.
     * @param y      The y-coordinate of the omnivore's position.
     */
    public Omnivore(String name, int energy, int x, int y) {
        super(name, energy, x, y);
    }

    /**
     * Performs the omnivore's action in the ecosystem.
     * The omnivore first tries to hunt a herbivore, then attempts to eat a plant if no herbivore is found.
     *
     * @param entities A list of EcosystemEntity objects representing all entities in the ecosystem.
     * @return An ActionResult object indicating the success or failure of the action,
     *         along with a description of what occurred.
     */
    @Override
    public ActionResult action(List<EcosystemEntity> entities) {
        super.action(entities);

        for (EcosystemEntity entity : entities) {
            if (entity instanceof Herbivore) {
                entities.remove(entity);
                energy += 25;
                return new SuccessActionResult(name + " hunted " + entity.name + " and gained energy.");
            }
        }

        for (EcosystemEntity entity : entities) {
            if (entity instanceof Plant) {
                entities.remove(entity);
                energy += 15;
                return new SuccessActionResult(name + " ate " + entity.name + " and gained energy.");
            }
        }

        return new FailureActionResult("No suitable prey found.");
    }

    /**
     * Checks if the omnivore has enough energy to reproduce.
     *
     * @return true if the omnivore's energy is 60 or greater, false otherwise.
     */
    @Override
    public boolean canReproduce() {
        return energy >= 60;
    }

    /**
     * Creates a new Omnivore object as offspring of this omnivore.
     * The parent's energy is reduced by 30 units during reproduction.
     *
     * @return A new Omnivore object representing the offspring.
     */
    @Override
    public EcosystemEntity reproduce() {
        energy -= 30;
        return new Omnivore(name + "_child", 30, x, y);
    }
}
