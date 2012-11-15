import guitypes.checkers.quals.*;

import java.util.List; // not explicitly annotated in the stub file

public class GenericsImplicitUIObjectBound {
    // This should be a valid type, because the implicit Object bound for List<T> should be lifted
    // to List<T extends @UI Object> rather than List<T extends @Safe Object>
    public List<@UI IGenericTask> l;

    // Since we're actually processing the definition here, the implicit upper bound should be lifted to @UI
    public static class Container<T> {
        T val;
    }

    // This should be satisfied because of the definition annotation.
    public Container<@UI IGenericTask> c;
}
