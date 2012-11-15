package guitypes.checkers;

import java.lang.annotation.Annotation;
import guitypes.checkers.quals.*;

public final class Effect {
    // I hate Java's comparable interface, so I'm not using it

    private final Class<? extends Annotation> annotClass;
    public Effect(Class<? extends Annotation> cls) {
        assert(cls.equals(UIEffect.class) || cls.equals(PolyUIEffect.class) || cls.equals(SafeEffect.class));
        annotClass = cls;
    }
    public static boolean LE(Effect left, Effect right) {
        assert (left != null && right != null);
        boolean leftBottom = left.annotClass.equals(SafeEffect.class);
        boolean rightTop = right.annotClass.equals(UIEffect.class);
        return leftBottom || rightTop || left.annotClass.equals(right.annotClass);
    }
    public static Effect min(Effect l, Effect r) {
        if (LE(l,r)) {
            return l;
        } else {
            return r;
        }
    }

    public static final class EffectRange {
        public final Effect min, max;
        public EffectRange(Effect min, Effect max) {
            assert(min != null || max != null);
            // If one is null, fill in with the other
            this.min = (min != null ? min : max);
            this.max = (max != null ? max : min);
        }
    }
    public boolean isSafe() { return annotClass.equals(SafeEffect.class); }
    public boolean isUI() { return annotClass.equals(UIEffect.class); }
    public boolean isPoly() { return annotClass.equals(PolyUIEffect.class); }
    public Class<? extends Annotation> getAnnot() { return annotClass; }

    @Override
    public String toString() {
        return annotClass.getSimpleName();
    }
    public boolean equals(Effect e) {
        return annotClass.equals(e.annotClass);
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Effect)
            return this.equals((Effect)o);
        else
            return super.equals(o);
    }
}
