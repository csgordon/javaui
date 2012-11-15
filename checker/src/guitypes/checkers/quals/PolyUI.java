package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Annotation for the polymorphic-UI effect
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // likely unnecessary
@Target({
        ElementType.TYPE_USE,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE,
        //ElementType.METHOD,
        // ElementType.FIELD, // IT IS A BUG to allow this!  In this case, subtyping on 'this' can effectively change the field instantiation, introducing unsoundness!
        //ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE})
//@SubtypeOf({UI.class})
@PolymorphicQualifier
@TypeQualifier
public @interface PolyUI {}
