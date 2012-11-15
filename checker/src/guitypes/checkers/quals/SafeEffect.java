package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Annotation for the concrete safe effect on methods, or on field accesses
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
// This is NOT a type qualifier: it is an effect
@SubtypeOf({}) // Need to specify this so the annotated type mirror framework will not choke on this
public @interface SafeEffect {}
