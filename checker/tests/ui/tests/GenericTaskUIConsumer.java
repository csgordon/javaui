import guitypes.checkers.quals.*;

public interface GenericTaskUIConsumer {
    @SafeEffect public void runAsync(@UI IGenericTask t);
}
