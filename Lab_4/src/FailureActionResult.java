/**
 * Represents a failure result of an action in the ecosystem.
 * This class extends the {@link ActionResult} base class and is used to indicate
 * that an action was unsuccessful, providing a descriptive message about the failure.
 */
public class FailureActionResult extends ActionResult {

    /**
     * Constructs a new FailureActionResult with the specified failure message.
     *
     * @param message  a description of why the action failed.
     */
    public FailureActionResult(String message) {
        super(message);
    }
}

