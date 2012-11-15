import guitypes.checkers.quals.*;

@UIType
public class BadUIOverrideChild extends SafeParent {
    // Should be an error b/c we marked this @UIType
    //:: error: (conflicts.override)
    void m() {}
}
