package guitypes.checkers.quals;

import java.lang.annotation.*;
import com.sun.source.tree.*;

import checkers.quals.*;

/**
 * Annotation to override the UI effect on a class, and make a field or method safe for non-UI code
 * to use.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // likely unnecessary
@Target({
        ElementType.TYPE_USE,
        ElementType.TYPE_PARAMETER,
        //ElementType.METHOD,
        //ElementType.FIELD,
        //ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE})
// If I restrict type shape appropriately, and make the default receiver annotation for polyclasses PolyUI, I don't need ClassPolyUI
//@SubtypeOf({PolyUI.class,ClassPolyUI.class})
//@SubtypeOf({PolyUI.class})
@SubtypeOf({UI.class})
@DefaultQualifierInHierarchy
@ImplicitFor(trees={Tree.Kind.NULL_LITERAL})
@TypeQualifier
public @interface AlwaysSafe {}
