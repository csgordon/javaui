package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Annotation for the concrete UI effect on methods, or on field accesses
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
// This is NOT a type qualifier: it is an effect
@SubtypeOf({}) // Need to specify this so the annotated type mirror framework will not choke on this
public @interface UIEffect {}
