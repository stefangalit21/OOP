/**
 * Represents the result of an action performed by an ecosystem entity.
 * This is an abstract class that provides a base for specific action result types,
 * such as success or failure outcomes.
 */
public abstract class ActionResult {

    /** The message describing the outcome of the action. */
    private final String result;

    /**
     * Constructs an ActionResult with the specified result message.
     *
     * @param message  a description of the action's outcome.
     */
    public ActionResult(String message) {
        this.result = message;
    }

    /**
     * Retrieves the result message describing the outcome of the action.
     *
     * @return the result message.
     */
    public String getResult() {
        return result;
    }
}
