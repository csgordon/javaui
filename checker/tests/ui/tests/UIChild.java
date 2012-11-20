import guitypes.checkers.quals.*;

// Should not inherit @UI!
public class UIChild extends UIParent {
    @Override @UIEffect public void doingUIStuff() {
        // Overriding UI with UI
        thingy.dangerous();
    } 
    
    // Should be an error to make this @UI
    //:: error: (conflicts.override)
    @Override @UIEffect public void doingSafeStuff() {} 

    public void shouldNotBeUI() {
        //:: error: (call.invalid.ui)
        thingy.dangerous();
    }

    //:: error: (conflicts.annotations)
    @UIEffect @SafeEffect public void doubleAnnot1() {
    }
    //:: error: (conflicts.annotations)
    @UIEffect @PolyUIEffect public void doubleAnnot2() {
    }
    //:: error: (conflicts.annotations)
    @PolyUIEffect @SafeEffect public void doubleAnnot3() {
    }
}
