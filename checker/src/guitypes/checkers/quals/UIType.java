package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Class declaration annotation to make methods default to @UI
 *
 * Do NOT mark this @TypeQualifier.  It is not necessary to get access to it,
 * and doing so directs the checker framework to add all sorts of extra weird
 * semantics to its use.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // likely unnecessary
@Target({
        ElementType.TYPE
        })
@SubtypeOf({}) // Need to specify this so the annotated type mirror framework will not choke on this
public @interface UIType {}
