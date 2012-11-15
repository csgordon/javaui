package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Annotation for the polymorphic type declaration
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
// This is an annotation to declare a type as taking an effect parameter
// For extensions, we'll need to do @PolyUIType class Subclass extends @PolyUI Superclass
@SubtypeOf({}) // Need to specify this so the annotated type mirror framework will not choke on this
public @interface PolyUIType {}
