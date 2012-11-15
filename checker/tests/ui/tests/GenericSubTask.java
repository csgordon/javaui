import guitypes.checkers.quals.*;

@PolyUI
public class GenericSubTask implements @PolyUI IGenericTask {
    public GenericTaskUIConsumer uicons;
    public GenericTaskSafeConsumer safecons;

    @PolyUIEffect public void doGenericStuff() {
        // In here, it should be that this:@PolyUI
        uicons.runAsync(this); // should be okay
        //:: error: (argument.type.incompatible)
        safecons.runAsync(this); // should be error!
    }
}
