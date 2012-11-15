import guitypes.checkers.quals.*;
public class AnonInnerDefaults {

    public static interface SafeIface {
        public void doStuff();
    }
    public static interface ExplicitUIIface {
        @UIEffect public void doStuff();
    }
    @UIType public static interface UITypeIface {
        public void doStuff();
    }
    @PolyUIType public static interface PolyIface {
        @PolyUIEffect public void doStuff();
    }

    @UIEffect public void tryStuff(final UIElement e) {
        SafeIface s = new SafeIface() {
            public void doStuff() {
                //:: error: (call.invalid.ui)
                e.dangerous();
            }
        };
        ExplicitUIIface ex = new ExplicitUIIface() {
            public void doStuff() {
                e.dangerous(); // should be okay
            }
        };
        UITypeIface u = new UITypeIface() {
            public void doStuff() {
                e.dangerous(); // should be okay
            }
        };
        @UI PolyIface p = new @UI PolyIface() {
            public void doStuff() {
                e.dangerous(); // should be okay
            }
        };
        PolyIface p2 = new PolyIface() {
            public void doStuff() {
                //:: error: (call.invalid.ui)
                e.dangerous(); // should be okay
            }
        };
    }
}
