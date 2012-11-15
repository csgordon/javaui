import guitypes.checkers.quals.*;

@UIType
@UI public class UISubTask implements @UI IGenericTask {
    public UIElement el;

    // This method should *not* issue an error, because the override check should see we inherit from @UI IGenericTask, and instantiate the parent method effect
    // Implicitly @UIEffect
    public void doGenericStuff() {
        el.dangerous(); // should be okay in UI method
    }
}
