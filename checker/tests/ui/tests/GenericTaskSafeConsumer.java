import guitypes.checkers.quals.*;

public interface GenericTaskSafeConsumer {
    @SafeEffect public void runAsync(@AlwaysSafe IGenericTask t);
}
