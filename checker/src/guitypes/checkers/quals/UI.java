package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Annotation for the UI effect
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // likely unnecessary
@Target({
        ElementType.TYPE_USE,
        ElementType.TYPE_PARAMETER,
        //ElementType.TYPE,
        //ElementType.METHOD,
        //ElementType.FIELD,
        //ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE})
@SubtypeOf({})
@TypeQualifier
public @interface UI {}
