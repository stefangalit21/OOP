import java.util.List;

/**
 * An abstract base class representing an entity in the ecosystem.
 * Entities in the ecosystem, such as animals and plants, derive from this class
 * and must implement its abstract methods to define their specific behaviors.
 */
public abstract class EcosystemEntity {

    /** The name of the ecosystem entity. */
    protected String name;

    /** The current energy level of the ecosystem entity. */
    protected int energy;

    /** The x-coordinate of the entity's position in the ecosystem. */
    protected int x;

    /** The y-coordinate of the entity's position in the ecosystem. */
    protected int y;

    /**
     * Constructs a new EcosystemEntity with the specified attributes.
     *
     * @param name  the name of the entity.
     * @param energy  the initial energy level of the entity.
     * @param x  the x-coordinate of the entity's position.
     * @param y  the y-coordinate of the entity's position.
     */
    public EcosystemEntity(String name, int energy, int x, int y) {
        this.name = name;
        this.energy = energy;
        this.x = x;
        this.y = y;
    }

    /**
     * Defines the specific action that this entity performs in the ecosystem.
     * The implementation varies depending on the type of entity (e.g., herbivores eat plants).
     *
     * @param entities  a list of all entities currently in the ecosystem. The entity
     *                  may interact with others in this list during its action.
     * @return an {@link ActionResult} describing the outcome of the action.
     */
    public abstract ActionResult action(List<EcosystemEntity> entities);

    /**
     * Checks if the entity is capable of reproducing based on its current state.
     *
     * @return true if the entity can reproduce; false otherwise.
     */
    public abstract boolean canReproduce();

    /**
     * Creates a new instance of the same type as this entity to represent its offspring.
     *
     * @return a new {@link EcosystemEntity} instance representing the offspring.
     */
    public abstract EcosystemEntity reproduce();
}
