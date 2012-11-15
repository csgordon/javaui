package guitypes.checkers;

import checkers.basetype.BaseTypeChecker;
import checkers.basetype.BaseTypeVisitor;
import checkers.quals.TypeQualifiers;
import checkers.quals.Unqualified;
import checkers.source.SupportedLintOptions;
import checkers.types.*;
import guitypes.checkers.quals.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import checkers.util.*;

import com.sun.source.tree.CompilationUnitTree;

/*
 * Do NOT claim UIType, or mark UIType @TypeQualifier.  Otherwise the checker framework interprets
 * its presence on a class declaration in some weird way that causes errors on method calls
 * to @AlwaysSafe instances of the annotated class.
 */
@SupportedLintOptions({"debugSpew"})
@TypeQualifiers({
        // Actual qualifiers
        UI.class,PolyUI.class,AlwaysSafe.class // If I restrict type shape appropriately, and make the default receiver annotation for polyclasses PolyUI, I don't need ClassPolyUI ,ClassPolyUI.class
        // Annots we need to declare to use through the annotated type mirror framework
        //UIEffect.class, SafeEffect.class, PolyUIEffect.class, PolyUIType.class, UIType.class
        })
public class GUIEffectsChecker extends BaseTypeChecker {

    // Even with a correct classpath, the framework doesn't seem to find the visitor class.
    @Override
    protected BaseTypeVisitor<?> createSourceVisitor(CompilationUnitTree root) {
        return new GUIEffectsVisitor(this, root);
    }

    @Override
    public AnnotatedTypeFactory createFactory(CompilationUnitTree root) {
        return new GUIEffectsTypeFactory(this, root, getLintOption("debugSpew", false));
    }

    public ProcessingEnvironment getEnv() { return env; }

    ////@Override
    ////public boolean isValidUse(AnnotatedTypeMirror.AnnotatedDeclaredType declarationType,
    ////             AnnotatedTypeMirror.AnnotatedDeclaredType useType) {
    ////    // Confusingly, "new @UI Runnable { ... }" actually parses as "@UI class Anon... implements Runnable {...}; (@UI Runnable)new Anon..."
    ////    boolean ret;
    ////    // TODO: Lock this down once we can get access to a type factory to find non-qualifier annotations!
    ////    ret = true;
    ////    //Element decl = declarationType.getElement();
    ////    //ret =  useType.hasEffectiveAnnotation(AnnotationUtils.getInstance(env).fromClass(AlwaysSafe.class))   // Always applicable
    ////    //    || atypeFactory.getDeclAnnotations(decl, PolyUIType.class)                                        // Can apply any qual to an effect-polymorphic type
    ////    //    || atypeFactory.getDeclAnnotations(decl, UI.class);                                               // Handle UI instantiations of polymorphic interfaces, see above

    ////    if (!ret) {
    ////        System.err.print("Returning: "+ret+" for ");
    ////        System.err.print("useType: "+useType+" with hasAnno(safe)="+useType.hasAnnotation(AlwaysSafe.class)+" and hasExplicitAnno(safe)="+useType.hasExplicitAnnotation(AlwaysSafe.class)+", ");
    ////        System.err.println("declarationType: "+declarationType+", has Safe: "+declarationType.hasAnnotation(AlwaysSafe.class)+", hasExplicit Poly: "+declarationType.hasExplicitAnnotation(PolyUIType.class)+" hasAnnot Poly:"+declarationType.hasAnnotation(PolyUIType.class)+", hasAnnot UI:"+declarationType.hasAnnotation(UI.class));
    ////        System.err.println("    "+AlwaysSafe.class.getCanonicalName());
    ////        System.err.print("    useType "+useType+" has annos: ");
    ////        for (AnnotationMirror m : useType.getAnnotations()) {
    ////            System.err.print(m+"("+AnnotationUtils.annotationName(m)+"), ");
    ////        }
    ////        System.err.println();
    ////        System.err.print("    and explicit annos: ");
    ////        for (AnnotationMirror m : useType.getExplicitAnnotations()) {
    ////            System.err.print(m+"("+AnnotationUtils.annotationName(m)+"), ");
    ////        }
    ////        System.err.println();
    ////        System.err.print("    and effective annos: ");
    ////        for (AnnotationMirror m : useType.getEffectiveAnnotations()) {
    ////            System.err.print(m+"("+AnnotationUtils.annotationName(m)+"), ");
    ////        }
    ////        System.err.println();
    ////        System.err.println(useType.hasAnnotation(AlwaysSafe.class));
    ////        System.err.println(useType.hasExplicitAnnotation(AlwaysSafe.class));
    ////        System.err.println(AnnotationUtils.containsSame(useType.getEffectiveAnnotations(), useType.getAnnotationInHierarchy(AnnotationUtils.getInstance(env).fromClass(AlwaysSafe.class))));
    ////        System.err.println(useType.hasEffectiveAnnotation(AnnotationUtils.getInstance(env).fromClass(AlwaysSafe.class)));
    ////        System.err.print("    declarationType "+declarationType+", has annos: ");
    ////        for (AnnotationMirror m : declarationType.getAnnotations()) {
    ////            System.err.print(m+", ");
    ////        }
    ////        System.err.println();
    ////    }
    ////    return ret;
    ////}

    // Useful debug override; remember, the framework treats qualifiers on local variables flow-sensitively.
    //@Override
    //public boolean isSubtype(AnnotatedTypeMirror sub, AnnotatedTypeMirror sup)
    //{
    //    System.out.println("sub: " + sub + ", sup: " + sup);
    //    return super.isSubtype(sub,sup);
    //}

}
