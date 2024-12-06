import java.util.List;

public abstract class Animal extends EcosystemEntity {
    public Animal(String name, int energy, int x, int y) {
        super(name, energy, x, y);
    }

    @Override
    public ActionResult action(List<EcosystemEntity> entities) {
        energy -= 5;
        if (energy <= 0) {
            entities.remove(this);
            return new FailureActionResult(name + " has died of exhaustion.");
        }

        return new SuccessActionResult("");
    }
}
