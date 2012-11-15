package ui.testdrivers;

import java.io.File;
import java.util.Collection;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import checkers.util.test.*;

/**
 */
@RunWith(CheckerParameterized.class)
public class UITestDriver extends ParameterizedCheckerTest {

    public UITestDriver(File testFile) {
        // TODO: This "guieffects" is supposed to the the "String checkerDir" in the parent class, and should probably be tests/ui or ui or something like that
        // Note that several superclasses up, it hardcodes "tests"+File.separator+checkerDir
        super(testFile, guitypes.checkers.GUIEffectsChecker.class.getName(), "ui/tests",
                "-Anomsgtext");
                //"-Anomsgtext", "-Alint=debugSpew");
        //System.out.println("Kicking off UITestDriver");
    }

    @Parameters
    public static Collection<Object[]> data() {
        //System.out.println("Getting test data dirs");
        return testFiles("ui/tests");
    }
}
