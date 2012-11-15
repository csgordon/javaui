package guitypes.checkers.quals;

import java.lang.annotation.*;

import checkers.quals.*;

/**
 * Package annotation to make all classes within a package @UIType
 *
 * Do NOT mark this @TypeQualifier.  It is not necessary to get access to it,
 * and doing so directs the checker framework to add all sorts of extra weird
 * semantics to its use.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) // likely unnecessary
@Target({
        ElementType.PACKAGE
        })
public @interface UIPackage {}
