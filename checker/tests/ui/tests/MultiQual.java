import guitypes.checkers.quals.*;

/*
 * NOTE: This is a test for a feature we do not yet implement.  Missing this wasn't an issue in case studies,
 * but this would be nice to have.
 *
 * A test class for verifying correct functionality for classes implementing multiple
 * effect-polymorphic supertypes, each with different qualifiers.
 *
 * By default, explicit annotations on implements/extends clauses are only kept if the same
 * _qualifier_ is applied to the type declaration!  Differing qualifiers are silently changed to the
 * default / class-decl-qualifier by the checker framework.
 */
public class MultiQual {
    public static @PolyUIType interface A { public @PolyUIEffect void mA(); }
    public static @PolyUIType interface B { public @PolyUIEffect void mB(); }
    public static @PolyUIType interface P { public @PolyUIEffect void mP(); }
    public static @PolyUIType interface X { public @PolyUIEffect void mX(); }

    public static @UIEffect void ui_action() { }

    // Polymorphic class that implements three interfaces, each w/ different effect
    // Also implement @AlwaysSafe X, but try to improperly implement it with a UI effect
    public static @PolyUIType class C implements @UI A, @AlwaysSafe B, @PolyUI P, @AlwaysSafe X {
        // Implement @UI A
        public @UIEffect void mA() {
            MultiQual.ui_action();
        }

        // Implement @AlwaysSafe B
        public void mB() { // implicitly safe
        }

        // Implement @PolyUI P
        public @PolyUIEffect void mP() {
            // Don't need to do much here, but we need to try call sites to @UI and @Safe versions of C
        }

        // Incorrectly implement @AlwaysSafe X (wrong effect)
        //:: error: (conflicts.override)
        public @UIEffect void mX() {
            MultiQual.ui_action();
        }
    }

    public static void main(String[] args) {
        @UI C uic = new @UI C();
        @AlwaysSafe C safec = new C();

        // Both variants implement @UI A
        @UI A a = uic;
        a = safec;
        //:: error: (call.invalid.ui)
        uic.mA(); // ui
        //:: error: (call.invalid.ui)
        safec.mA(); // ui

        // Both implement @AlwaysSafe B
        @AlwaysSafe B b = uic;
        b = safec;
        uic.mB();
        safec.mB();

        // Each instantiates @PolyUI P with its own effect
        @UI P uip = uic;
        @AlwaysSafe P safep = safec;
        // So calling each P method has different effects
        //:: error: (call.invalid.ui)
        uic.mP(); // UI effect
        safec.mP();

        // Both implement @AlwaysSafe X (incorrectly, but the types should work here)
        @AlwaysSafe X x = uic;
        x = safec;
        x.mX();
    }
}
